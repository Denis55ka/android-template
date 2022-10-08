package app.denis55ka.core

object Components : MutableSet<Any> by mutableSetOf() {

    inline fun <reified T> get(): T = filterIsInstance<T>().single()
}
