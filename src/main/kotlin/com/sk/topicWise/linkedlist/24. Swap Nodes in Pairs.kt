package com.sk.topicWise.linkedlist

private fun swapPairs(head: ListNode?): ListNode? {
    val dummy = ListNode(0)
    dummy.next = head
    var current: ListNode? = dummy
    while (current!!.next != null && current.next!!.next != null) {
        val first = current.next
        val second = current.next!!.next
        first!!.next = second!!.next
        current.next = second
        current.next!!.next = first
        current = current.next!!.next
    }
    return dummy.next
}
