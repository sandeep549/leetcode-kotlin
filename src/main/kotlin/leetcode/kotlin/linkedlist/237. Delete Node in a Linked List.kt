package leetcode.kotlin.linkedlist

fun main() {
    var head = "[4,5,1,9]".toLinkedList()
    println(head.toString())
    deleteNode(head?.next)
    println(head.toString())
}

/**
Note:
The linked list will have at least two elements.
All of the nodes' values will be unique.
The given node will not be the tail and it will always be a valid node of the linked list.
Do not return anything from your function.
 */
private fun deleteNode(node: ListNode?) {
    val tmp = node!!.next
    node.`val` = tmp!!.`val`
    node.next = tmp.next
    tmp.next = null // isolate this mode from list
}

private fun deleteNode2(node: ListNode?) {
    node?.let {
        it.`val` = it.next!!.`val` //we know next is never null from question
        it.next = it.next!!.next
    }
}
