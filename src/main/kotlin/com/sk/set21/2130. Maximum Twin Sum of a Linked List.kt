package com.sk.set21

import com.sk.topicWise.linkedlist.ListNode

class Solution2130 {
    fun pairSum(head: ListNode?): Int {
        fun reverse(n: ListNode?): ListNode? {
            var cur = n
            var newHead: ListNode? = null
            while (cur != null) {
                val next = cur.next
                cur.next = newHead
                newHead = cur
                cur = next
            }
            return newHead
        }

        //printList(head)

        var slow = head
        var fast = head
        while (fast != null && fast.next != null) {
            slow = slow!!.next
            fast = fast.next.next
        }

        slow = reverse(slow)

        var l = head
        var r = slow
        var max = 0
        while (r != null) {
            max = maxOf(max, l!!.`val` + r!!.`val`)
            l = l.next
            r = r.next
        }

        reverse(slow) // revert back list
        //printList(head)

        return max
    }

    private fun printList(n: ListNode?) {
        var c = n
        while (c != null) {
            println(c.`val`)
            c = c.next
        }
    }
}
