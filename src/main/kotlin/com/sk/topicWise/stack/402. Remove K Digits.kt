package com.sk.topicWise.stack

import java.util.ArrayDeque

private fun removeKdigits(num: String, k: Int): String? {
    var k = k
    if (k >= num.length) return "0"

    val stack = ArrayDeque<Char>()
    for (c in num.toCharArray()) {
        while (k > 0 && !stack.isEmpty() && stack.peekLast() > c) {
            stack.removeLast()
            k--
        }
        stack.addLast(c)
    }

    while (k > 0) {
        stack.removeLast()
        k--
    }

    // Remove all zeros from the front of the stack and then if stack is empty, return "0"
    while (!stack.isEmpty() && stack.peekFirst() == '0') stack.removeFirst()
    if (stack.isEmpty()) return "0"

    // build the number from the stack
    val sb = StringBuilder()
    while (!stack.isEmpty()) {
        sb.append(stack.removeFirst())
    }
    return sb.toString()
}
