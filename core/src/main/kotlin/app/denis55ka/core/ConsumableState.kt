package app.denis55ka.core

import java.util.concurrent.atomic.AtomicBoolean

open class ConsumableState {

    private val consumed = AtomicBoolean()

    fun consume(): Boolean = consumed.compareAndSet(false, true)
}
