package topicWise.linkedlist

private fun getDecimalValue(head: ListNode?): Int {
    var result = 0
    var head = head
    while (head != null) {
        result = (result shl 1) xor head.`val`
        head = head.next
    }
    return result
}
