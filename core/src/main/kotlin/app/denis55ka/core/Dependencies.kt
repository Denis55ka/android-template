package app.denis55ka.core

object Dependencies : MutableSet<Any> by mutableSetOf() {

    inline fun <reified T> get(): T = filterIsInstance<T>().single()
}
