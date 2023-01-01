package topicWise.linkedlist

private fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var list1 = l1
    var list2 = l2
    var c = 0
    val dummy = ListNode(0)
    var d = dummy
    while (list1 != null || list2 != null || c != 0) {
        val a = list1?.`val` ?: 0
        val b = list2?.`val` ?: 0
        d.next = ListNode((a + b + c) % 10)
        d = d.next!!
        c = (a + b + c) / 10
        if (list1 != null) list1 = list1.next
        if (list2 != null) list2 = list2.next
    }
    return dummy.next
}
