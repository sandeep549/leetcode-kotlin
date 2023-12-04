package com.sk.set1

import com.sk.topicWise.linkedlist.ListNode

class Solution148 {
    fun sortList(head: ListNode?): ListNode? {
        if (head?.next == null) return head

        // step 1. cut the list to two halves
        var prev: ListNode? = null
        var slow = head
        var fast = head
        while (fast?.next != null) {
            prev = slow
            slow = slow!!.next
            fast = fast.next!!.next
        }
        prev!!.next = null

        // step 2. sort each half
        val l1 = sortList(head)
        val l2 = sortList(slow)

        // step 3. merge l1 and l2
        return merge(l1, l2)
    }

    fun merge(l1: ListNode?, l2: ListNode?): ListNode? {
        var list1 = l1
        var list2 = l2
        val dummy = ListNode(0)
        var p  = dummy
        while (list1 != null && list2 != null) {
            if (list1.`val` < list2.`val`) {
                p.next = list1
                list1 = list1.next
            } else {
                p.next = list2
                list2 = list2.next
            }
            p = p.next!!
        }
        if (list1 != null) p.next = list1
        if (list2 != null) p.next = list2
        return dummy.next
    }
}