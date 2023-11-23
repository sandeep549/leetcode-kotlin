package com.sk.topicWise.linkedlist.medium

import com.sk.topicWise.linkedlist.ListNode


class Solution82 {

    /**
     * Any node will remain in the list, is decided by next node.
     * User pointer r to traverse through the list
     *
     */
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head == null) return null
        val dummy = ListNode(0)
        dummy.next = head
        var pre = dummy
        var cur = head
        while (cur != null) {
            while (cur!!.next != null && cur.`val` == cur.next!!.`val`) {
                cur = cur.next
            }
            if (pre.next == cur) {
                pre = pre.next!!
            } else {
                pre.next = cur.next
            }
            cur = cur.next
        }
        return dummy.next
    }
}