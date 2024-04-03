package app.denis55ka.core.viewmodel.extensions

import app.denis55ka.core.viewmodel.ActionState

inline fun <T> ActionState<T>.onSuccess(action: ActionState.Success<T>.() -> Unit) {
    if (this is ActionState.Success) {
        action(this)
    }
}

inline fun <T> ActionState<T>.onSuccessConsume(action: ActionState.Success<T>.() -> Unit) {
    if (this is ActionState.Success && consume()) {
        action(this)
    }
}

inline fun <T> ActionState<T>.onError(action: ActionState.Error<T>.() -> Unit) {
    if (this is ActionState.Error) {
        action(this)
    }
}

inline fun <T> ActionState<T>.onErrorConsume(action: ActionState.Error<T>.() -> Unit) {
    if (this is ActionState.Error && consume()) {
        action(this)
    }
}
