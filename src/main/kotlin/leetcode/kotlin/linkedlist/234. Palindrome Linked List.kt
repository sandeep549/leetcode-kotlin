package leetcode.kotlin.linkedlist

// Solution-1
fun isPalindrome(head: ListNode?): Boolean {
    fun reverse(head: ListNode?): ListNode? {
        if (head == null) return null
        var newhead: ListNode? = null
        var curr: ListNode? = head
        while (curr != null) {
            var next = curr.next
            curr.next = newhead
            newhead = curr
            curr = next
        }
        return newhead
    }
    if (head?.next == null) return true
    var slow: ListNode? = head
    var fast: ListNode? = head
    while (fast?.next != null) {
        slow = slow!!.next
        fast = fast.next!!.next
    }
    if (fast != null) {
        slow = slow!!.next
    }
    slow = reverse(slow)
    fast = head
    while (slow != null) {
        if (fast!!.`val` != slow.`val`) return false
        fast = fast.next
        slow = slow.next
    }
    return true
}

private fun isPalindrome3(head: ListNode?): Boolean {
    if (head == null) return true
    var left = head
    fun rightCheck(node: ListNode?): Boolean { // checks at very node for corresponding node
        if (node == null) return true
        val isPal = rightCheck(node.next) && (left!!.`val` == node.`val`)
        left = left!!.next
        return isPal
    }
    return rightCheck(head)
}

// Solution-2, tough needs more verification on edge cases to check
// TODO verify it
private fun isPalindrome2(head: ListNode?): Boolean {
    var sum = 0
    var mul = -1
    var curr = head
    while (curr != null) {
        sum += (2.shl(++mul)) * curr.`val`
        curr = curr!!.next
    }
    curr = head
    while (curr != null) {
        sum -= (2.shl(mul--)) * curr.`val`
        curr = curr!!.next
    }
    return sum == 0
}

private fun endOfFirstHalf(head: ListNode): ListNode {
    var slow = head
    var fast = head
    while (fast.next != null && fast.next!!.next != null) {
        slow = slow.next!!
        fast = fast.next!!.next!!
    }
    return slow
}

private fun reverse(head: ListNode?): ListNode? {
    var pre: ListNode? = null
    var curr: ListNode? = head
    while (curr != null) {
        val next = curr.next
        curr.next = pre
        pre = curr
        curr = next
    }
    return pre
}

// todo : Explain this?
private fun isPalindrome4(head: ListNode?): Boolean {
    var sum = 0
    var mul = -1
    var curr = head
    while (curr != null) {
        sum += (2.shl(++mul)) * curr.`val`
        curr = curr.next
    }
    curr = head
    while (curr != null) {
        sum -= (2.shl(mul--)) * curr.`val`
        curr = curr.next
    }
    return sum == 0
}
