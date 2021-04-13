package leetcode.kotlin.array.medium

import java.util.Stack

private fun nextGreaterElement(n: Int): Int {
    val incStack = Stack<Int>()
    var num = n
    while (num > 0) {
        var curdigit = num % 10
        num /= 10
        if (incStack.isEmpty() || curdigit >= incStack.peek()) {
            incStack.push(curdigit)
        } else {
            val decStack = Stack<Int>()
            while (incStack.isNotEmpty()) {
                decStack.push(incStack.pop())
                if (curdigit < decStack.peek() && (incStack.isEmpty() || curdigit >= incStack.peek())) {
                    val tmp = curdigit
                    curdigit = decStack.pop()
                    decStack.push(tmp)
                    while (incStack.isNotEmpty()) decStack.push(incStack.pop())
                    decStack.push(curdigit)
                    while (decStack.isNotEmpty()) {
                        val digit = decStack.pop()
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