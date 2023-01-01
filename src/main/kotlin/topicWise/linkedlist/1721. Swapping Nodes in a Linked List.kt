package topicWise.linkedlist

private fun swapNodes(head: ListNode?, k: Int): ListNode? {
    val dummy = ListNode(-1)
    dummy.next = head
    var firstPrev: ListNode? = dummy
    for (i in 0 until k - 1) {
        firstPrev = firstPrev!!.next
    }
    var secondPrev: ListNode? = dummy
    var advanced = firstPrev!!.next!!.next
    while (advanced != null) {
        secondPrev = secondPrev!!.next
        advanced = advanced.next
    }

    val first = firstPrev.next
    val second = secondPrev!!.next
    val firstNodeAfter = first!!.next
    val secondNodeAfter = second!!.next
    if (second.next == first) {
        secondPrev.next = first
        first.next = second
        second.next = firstNodeAfter
    } else if (secondPrev == first) {
        firstPrev.next = second
        second.next = first
        first.next = secondNodeAfter
    } else {
        firstPrev.next = second
        second.next = firstNodeAfter
        secondPrev.next = first
        first.next = secondNodeAfter
    }
    return dummy.next
}
