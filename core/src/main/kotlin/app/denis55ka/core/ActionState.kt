package app.denis55ka.core

sealed class ActionState<out T>(
    open val data: T? = null,
    open val exception: Exception? = null
) : ConsumableState() {

    class Idle<out T>(data: T? = null) : ActionState<T>(data)

    class Loading<out T>(data: T? = null) : ActionState<T>(data)

    class Success<out T>(override val data: T) : ActionState<T>(data)

    class Error<out T>(data: T? = null, override val exception: Exception) : ActionState<T>(data, exception)
}
