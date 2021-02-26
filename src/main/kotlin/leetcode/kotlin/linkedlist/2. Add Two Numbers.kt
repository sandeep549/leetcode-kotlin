package leetcode.kotlin.linkedlist

private fun addTwoNumbers3(l1: ListNode?, l2: ListNode?): ListNode? {
    var n1 = l1
    var n2 = l2
    var c = 0
    val dummy = ListNode(0)
    var d = dummy
    while (n1 != null || n2 != null || c != 0) {
        val a = n1?.`val` ?: 0
        val b = n2?.`val` ?: 0
        d.next = ListNode((a + b + c) % 10)
        d = d.next!!
        c = (a + b + c) / 10
        if (n1 != null) n1 = n1.next
        if (n2 != null) n2 = n2.next
    }
    return dummy.next
}

class Solution {
    fun ListNode?.value() = this?.`val` ?: 0
    fun ListNode?.nextNode() = this?.next
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var n1 = l1
        var n2 = l2
        var c = 0
        val dummy = ListNode(0)
        var d = dummy
        while (n1 != null || n2 != null || c != 0) {
            val a = n1.value()
            val b = n2.value()
            d.next = ListNode((a + b + c) % 10)
            d = d.next!!
            c = (a + b + c) / 10
            n1 = n1.nextNode()
            n2 = n2.nextNode()
        }
        return dummy.next
    }
}

class Solution2 {
    fun ListNode?.value() = this?.`val` ?: 0

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?, carry: Int = 0): ListNode? {
        if (l1 == null && l2 == null && carry == 0) return null
        val s = l1.value() + l2.value() + carry
        return ListNode(s % 10).apply { next = addTwoNumbers(l1?.next, l2?.next, s / 10) }
    }
}
