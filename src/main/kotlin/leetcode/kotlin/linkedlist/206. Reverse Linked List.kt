package leetcode.kotlin.linkedlist

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
    fun recur(newHead: ListNode?, cur: ListNode?): ListNode? {
        if (cur == null) return newHead
        var next = cur.next
        cur.next = newHead
        return recur(cur, next)
    }
    return recur(null, head)
}
