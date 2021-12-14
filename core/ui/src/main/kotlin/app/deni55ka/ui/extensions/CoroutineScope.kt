package app.deni55ka.ui.extensions

import app.deni55ka.core.ActionState
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun CoroutineScope.launchTo(
    target: MutableStateFlow<in ActionState<Unit>>,
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
): Job = launch(context, start) {
    target.value = ActionState.Loading()
    try {
        block()
        target.value = ActionState.Success(Unit)
    } catch (expected: CancellationException) {
        target.value = ActionState.Idle()
    } catch (exception: Exception) {
        target.value = ActionState.Error(exception = exception)
    }
}

fun <T> CoroutineScope.asyncTo(
    target: MutableStateFlow<in ActionState<T>>,
    default: T? = null,
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> T
): Deferred<Result<T>> = async(context, start) {
    target.value = ActionState.Loading(default)
    try {
        val result = block()
        target.value = ActionState.Success(result)
        Result.success(result)
    } catch (exception: CancellationException) {
        target.value = ActionState.Idle(default)
        Result.failure(exception)
    } catch (exception: Exception) {
        target.value = ActionState.Error(default, exception)
        Result.failure(exception)
    }
}
