package topicWise.linkedlist

private fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
    val stack = ArrayDeque<ListNode>()
    val dummy = ListNode(-0)
    dummy.next = head
    var cur = dummy.next
    var pre = dummy
    var cnt = 1

    while (cnt != left) {
        pre = cur!!
        cur = cur.next
        cnt++
    }

    while (cnt != right + 1) {
        stack.add(cur!!)
        cur = cur.next
        cnt++
    }

    while (stack.isNotEmpty()) {
        pre.next = stack.removeLast()
        pre = pre.next!!
    }
    pre.next = cur

    return dummy.next
}

private fun reverseBetween2(head: ListNode?, left: Int, right: Int): ListNode? {
    if (right - left == 0) return head

    var cnt = 1
    val dummy = ListNode(0)
    dummy.next = head
    var pre = dummy

    var cur = head
    while (cnt != left) {
        cnt++
        pre = cur!!
        cur = cur.next
    }

    var hd = cur
    val last = cur
    while (cnt != right + 1) {
        val nxt = cur!!.next
        cur.next = hd
        hd = cur
        cur = nxt
        cnt++
    }

    pre.next = hd
    last!!.next = cur

    return dummy.next
}
