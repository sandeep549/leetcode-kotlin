package com.sk.set16

import com.sk.topicWise.linkedlist.ListNode

class Solution1669 {
    fun mergeInBetween(list1: ListNode?, a: Int, b: Int, list2: ListNode?): ListNode? {
        var list2 = list2
        var curr = list1
        var start: ListNode? = null
        var count = 0
        while (count < b) {
            if (count == a - 1) {
                start = curr
            }
            count++
            curr = curr!!.next
        }
        start!!.next = list2
        while (list2!!.next != null) { // traverse till the end of list2.
            list2 = list2.next
        }
        list2.next = curr!!.next // connect end of list2 to the node right after b.
        curr.next = null // cut off b from list1.
        return list1
    }
}