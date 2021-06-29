package leetcode.kotlin.array.medium

import java.util.Stack

private fun nextGreaterElement(n: Int): Int {
    val incStack = Stack<Int>() // keeps elements in increasing order
    var num = n
    while (num > 0) {
        var digit = num % 10
        num /= 10
        if (incStack.isEmpty() || digit >= incStack.peek()) {
            incStack.push(digit)
        } else { // First digit smaller from its right digit
            // Find just bigger digit from this one
            val decStack = Stack<Int>() // keeps element in non-increasing order
            while (incStack.isNotEmpty()) {
                decStack.push(incStack.pop())
                if (digit < decStack.peek() && (incStack.isEmpty() || digit >= incStack.peek())) {
                    // Found just bigger digit at decreasing stack top
                    val justBigger = decStack.pop()
                    decStack.push(digit)
                    while (incStack.isNotEmpty()) decStack.push(incStack.pop()) // Arrange right side digit in increasing order
                    decStack.push(justBigger) // Keep just bigger digit at top, to make next bigger no
                    while (decStack.isNotEmpty()) { // build the final no, checking overflow at each step
                        digit = decStack.pop()
                        if (num > 214_748_364) return -1
                        num *= 10
                        if (num >= 214_748_364_0 && digit > 7) return -1
                        num += digit
                    }
                    return num
                }
            }
        }
    }
    return -1
}