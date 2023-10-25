package com.sk.topicWise.linkedlist

fun main() {
}

private fun hasCycle(head: ListNode?): Boolean {
    val visited = HashSet<ListNode>()
    var curr = head
    while (curr != null) {
        if (visited.contains(curr)) return true
        visited.add(curr)
        curr = curr.next
    }
    return false
}

private fun hasCycle2(head: ListNode?): Boolean {
    if (head == null) return false
    var slow = head
    var fast = head.next
    while (fast?.next != null && slow != fast) {
        slow = slow?.next
        fast = fast.next?.next
    }
    return slow == fast
}
