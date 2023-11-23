package com.sk.topicWise.linkedlist.medium

import com.sk.topicWise.linkedlist.ListNode


class Solution61 {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        var size = 0
        var cur = head
        while (cur != null) {
            size++
            cur = cur.next
        }
        if (size == 0 || k % size == 0) return head

        val rot = k % size
        cur = head
        var n = 0
        while (n < rot) {
            cur = cur?.next
            n++
        }

        var pre = head
        while (cur!!.next != null) {
            cur = cur.next
            pre = pre!!.next
        }

        val newHead = pre!!.next
        pre.next = null
        cur.next = head

        return newHead
    }

    fun rotateRight2(head: ListNode?, k: Int): ListNode? {
        if (head == null) return null
        var size = 1
        var tail = head

        while (tail?.next != null) {
            size++
            tail = tail.next
        }

        tail?.next = head

        val newHeadIndex = size - k % size
        for (i in 0 until newHeadIndex) {
            tail = tail?.next
        }

        val newHead = tail?.next
        tail?.next = null
        return newHead
    }
}