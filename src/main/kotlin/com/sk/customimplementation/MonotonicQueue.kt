package com.sk.customimplementation

/**
 * Monotonic increasing/decreasing queue.
 */
interface MonotonicQueue<E> {
    fun add(e: E)
    fun peekFirst(): E
    fun peekLast(): E
    fun removeFirst(): E
    fun removeLast()
    fun size(): Int
}