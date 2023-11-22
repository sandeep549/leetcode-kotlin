package com.sk.topicWise.linkedlist.medium

import com.sk.topicWise.linkedlist.ListNode

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

class Solution19 {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var fast = head
        var slow = head
        // Move until n nodes has been passed, slow and fast are n node apart(fast-slow=n)
        for (i in 0 until n) fast = fast!!.next
        if (fast == null) return head?.next
        while (fast!!.next != null) {
            fast = fast.next
            slow = slow!!.next
        }
        slow!!.next = slow.next!!.next
        return head
    }
}
