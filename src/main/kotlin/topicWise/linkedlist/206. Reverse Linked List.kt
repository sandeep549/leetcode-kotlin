package topicWise.linkedlist

// iterative
private fun reverseList(head: ListNode?): ListNode? {
    var curr = head
    var newHead: ListNode? = null
    while (curr != null) {
        val next = curr.next
        curr.next = newHead
        newHead = curr
        curr = next
    }
    return newHead
}

// recursive implementation
private fun reverseList2(head: ListNode?): ListNode? {

    return recur(null, head)
}

private fun recur(newHead: ListNode?, cur: ListNode?): ListNode? {
    if (cur == null) return newHead
    val next = cur.next
    cur.next = newHead
    return recur(cur, next)
}
