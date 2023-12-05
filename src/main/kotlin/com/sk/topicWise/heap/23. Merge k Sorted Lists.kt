package com.sk.topicWise.heap

import com.sk.topicWise.linkedlist.ListNode
import java.util.*

class Solution23 {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.isEmpty()) return null
        val dummy = ListNode(0)
        var tail = dummy
        val q = PriorityQueue<ListNode>(lists.size) { l1, l2 -> l1.`val`-l2.`val`}
        lists.forEach { it?.let { q.add(it) } }
        while (q.isNotEmpty()) {
            tail.next = q.poll()
            tail = tail.next!!
            if (tail.next != null) {
                q.add(tail.next)
            }
        }
        return dummy.next
    }
}
