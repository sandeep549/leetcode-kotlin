package com.sk.set0

import com.sk.topicWise.linkedlist.ListNode


class Solution25 {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        val s = ArrayDeque<ListNode>()
        var curr = head
        val dummy = ListNode(0)
        var pre = dummy

        while (curr != null) {
            s.addLast(curr)
            curr = curr.next

            if (s.size == k) {
                while (s.isNotEmpty()) {
                    pre.next = s.removeLast()
                    pre = pre.next!!
                }
            }
        }

        if (s.isNotEmpty()) {
            pre.next = s.first()
        } else {
            pre.next = null
        }


        return dummy.next
    }

    fun reverseKGroup2(head: ListNode?, k: Int): ListNode? {
        if (head?.next == null || k == 1) return head
        var head = head

        val dummyhead = ListNode(-1)
        dummyhead.next = head
        var begin = dummyhead
        var i = 0
        while (head != null) {
            i++
            if (i % k == 0) {
                begin = reverse(begin, head.next)
                head = begin.next
            } else {
                head = head.next
            }
        }
        return dummyhead.next
    }

    fun reverse(begin: ListNode?, end: ListNode?): ListNode {
        var hd = begin
        var curr = begin!!.next
        val first = curr
        while (curr != end) {
            val next = curr!!.next
            curr.next = hd
            hd = curr
            curr = next
        }
        begin.next = hd
        first!!.next = end
        return first
    }
}