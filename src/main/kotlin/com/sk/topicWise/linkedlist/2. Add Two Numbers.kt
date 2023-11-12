package com.sk.topicWise.linkedlist

class Solution2 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var a = l1
        var b = l2
        var c = 0
        var x = 0
        var y = 0
        val dummy = ListNode(0)
        var curr = dummy
        while (a != null || b != null || c != 0) {
            if (a != null) {
                x = a.`val`
                a = a.next
            } else {
                x = 0
            }
            if (b != null) {
                y = b.`val`
                b = b.next
            } else {
                y = 0
            }
            val v = (x + y + c) % 10
            c = (x + y + c) / 10
            curr.next = ListNode(v)
            curr = curr.next!!
        }
        return dummy.next
    }
}
