package com.sk.topicWise.linkedlist.medium

import com.sk.topicWise.linkedlist.ListNode


class Solution86 {
    fun partition(head: ListNode?, x: Int): ListNode? {
        if (head == null) return null
        val first = ArrayList<Int>()
        val second = ArrayList<Int>()
        var cur = head
        while (cur != null) {
            if (cur.`val` < x) first.add(cur.`val`)
            else second.add(cur.`val`)
            cur = cur.next
        }

        val dummy = ListNode(0)
        cur = dummy
        for (item in first) {
            cur?.next = ListNode(item)
            cur = cur?.next
        }
        for (item in second) {
            cur?.next = ListNode(item)
            cur = cur?.next
        }
        return dummy.next
    }

    fun partition2(head: ListNode?, x: Int): ListNode? {
        val smallerHead = ListNode(0)
        val biggerHead = ListNode(0)
        var smaller: ListNode? = smallerHead
        var bigger: ListNode? = biggerHead
        var cur = head
        while (cur != null) {
            if (cur.`val` < x) {
                smaller!!.next = cur
                smaller = smaller.next
            } else {
                bigger!!.next = cur
                bigger = bigger.next
            }
            cur = cur.next
        }
        // no need for extra check because of fake heads
        smaller!!.next = biggerHead.next // join bigger after smaller

        bigger!!.next = null // cut off anything after bigger

        return smallerHead.next
    }
}