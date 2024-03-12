package com.sk.topicWise.linkedlist.medium

import com.sk.topicWise.linkedlist.ListNode


class Solution1171 {
    fun removeZeroSumSublists(head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        val map = HashMap<Int, ListNode>()
        map[0] = dummy
        var cur: ListNode? = dummy
        var sum = 0
        while (cur != null) {
            sum += cur.`val`
            map[sum] = cur
            cur = cur.next
        }

        sum = 0
        cur = dummy
        while (cur != null) {
            sum += cur.`val`
            cur.next = map[sum]!!.next
            cur = cur.next
        }
        return dummy.next
    }
}