package com.sk.leetcode

import com.sk.topicWise.linkedlist.ListNode

private class Solution {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var list1 = l1
        var list2 = l2
        val dummy = ListNode(0)
        var cur = dummy
        while(list1 != null && list2 != null) {
            if(list1.`val` <= list2.`val`) {
                cur.next = list1
                list1 = list1.next
            } else {
                cur.next = list2
                list2 = list2.next
            }
            cur = cur.next!!
        }
        if(list1 != null) cur.next = list1
        if(list2 != null) cur.next = list2
        return dummy.next
    }
}