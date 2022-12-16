package leetcode.kotlin.z_ImportantCodeSnippet

import java.util.ArrayDeque
import java.util.Deque
import java.util.LinkedList

/**
 * Queue:
 * offer(), add()
 * remove(), poll()
 * peek()
 */
private fun queueInKotlin() {
    // 1
    val queue1: Deque<Int> = ArrayDeque()
    queue1.add(1)
    queue1.add(2)
    queue1.remove()
    queue1.peekFirst()
    queue1.isEmpty()
    queue1.size

    // 2
    var queue2: Deque<Int> = LinkedList()
    queue2.offer(1)
    queue2.offer(2)
    queue2.offer(3)
    println(queue2.toList())
    queue2.poll()
    println(queue2.toList())
    println(queue2.peek())
}
