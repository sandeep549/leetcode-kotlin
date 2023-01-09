package z_ImportantCodeSnippet

import java.util.ArrayDeque
import java.util.Deque
import java.util.LinkedList

/**
 * Stack:
 * push()
 * pop()
 * peek()
 */
private fun stackInKotlin() {
    // 1
    val stack1: Deque<Int> = ArrayDeque()
    stack1.push(1)
    stack1.push(2)
    stack1.pop()
    stack1.peek()
    stack1.peekFirst()
    stack1.isEmpty()
    stack1.size

    // 2
    val stack2: Deque<Int> = LinkedList()
    stack2.push(1)
    stack2.push(2)
    stack2.pop()
    stack2.peek()
    stack2.peekFirst()
    stack2.isEmpty()
    stack2.size
}
