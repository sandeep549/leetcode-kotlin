package com.sk.leetcode.easy

import com.sk.topicWise.linkedlist.ListNode

class Solution203 {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var cur = dummy.next
        var pre = dummy
        while (cur != null) {
            if (cur.`val` == `val`) {
                pre.next = cur.next
            } else {
                pre = cur
            }
            cur = cur.next
        }
        return dummy.next
    }
}