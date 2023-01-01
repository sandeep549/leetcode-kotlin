package topicWise.linkedlist

private fun oddEvenList(head: ListNode?): ListNode? {
    if (head == null) return null
    var odd = head
    var even = head.next
    val evenHead = even
    while (even?.next != null) { // ever time stand on even, odd non-null pair
        odd!!.next = odd.next!!.next
        even.next = even.next!!.next
        odd = odd.next
        even = even.next
    }
    odd!!.next = evenHead
    return head
}
