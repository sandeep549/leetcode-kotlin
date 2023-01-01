package topicWise.linkedlist

private fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    val dummy = ListNode(0)
    dummy.next = head
    var first: ListNode? = dummy
    var second: ListNode? = dummy
    for (i in 1..n + 1) first = first!!.next

    while (first != null) {
        first = first.next
        second = second!!.next
    }
    second!!.next = second.next!!.next
    return dummy.next
}
