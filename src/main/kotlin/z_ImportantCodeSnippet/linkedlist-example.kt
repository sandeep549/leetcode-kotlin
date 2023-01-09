package z_ImportantCodeSnippet

import java.util.Deque
import java.util.LinkedList

private fun PleaseRunToBetterUnderstandMe() {
    val m: Deque<Int> = LinkedList() // ArrayDeque()
    m.push(1)
    m.push(2)
    m.push(3)
    println(m.toList())
    println(m.peek())
    println(m.peekFirst())
    println(m.peekLast())
    m.offer(4)
    println(m.toList())
    println(m.peek())
    println(m.peekFirst())
    println(m.peekLast())
    m.add(5)
    println(m.toList())
    m.addFirst(6)
    m.addLast(7)
    println(m.toList())
    m.pop()
    println(m.toList())
    m.push(8)
    println(m.toList())
    m.poll()
    println(m.toList())
}
