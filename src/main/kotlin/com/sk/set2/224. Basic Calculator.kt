package com.sk.set2


class Solution {
    fun calculate(s: String): Int {
        val stack = ArrayDeque<Int>()
        var result = 0
        var number = 0
        var sign = 1
        for (i in s.indices) {
            val c = s[i]
            if (c.isDigit()) {
                number = 10 * number + (c.code - '0'.code)
            } else if (c == '+') {
                result += sign * number
                number = 0
                sign = 1
            } else if (c == '-') {
                result += sign * number
                number = 0
                sign = -1
            } else if (c == '(') {
                //we push the result first, then sign;
                stack.addLast(result)
                stack.addLast(sign)
                //reset the sign and result for the value in the parenthesis
                sign = 1
                result = 0
            } else if (c == ')') {
                result += sign * number
                number = 0
                result *= stack.removeLast() //stack.pop() is the sign before the parenthesis
                result += stack.removeLast() //stack.pop() now is the result calculated before the parenthesis
            }
        }
        if (number != 0) result += sign * number
        return result
    }

    fun calculate2(s: String): Int {
        var result = 0
        val stack = ArrayDeque<Int>()
        var number = 0
        var sign = 1
        for (i in s.indices) {
            val c = s[i]
            if (c.isDigit()) {
                number = 10 * number + (c.code - '0'.code)
            } else if (c == '+') {
                val n = sign * number * (stack.lastOrNull() ?: 1)
                result += n
                number = 0
                sign = 1
            } else if (c == '-') {
                val n = sign * number * (stack.lastOrNull() ?: 1)
                result += n
                number = 0
                sign = -1
            } else if (c == '(') {
                stack.addLast(sign * (stack.lastOrNull() ?: 1))
                sign = 1
            } else if (c == ')') {
                val n = sign * number * (stack.lastOrNull() ?: 1)
                result += n
                stack.removeLast()
                sign = 1
                number = 0
            }
        }
        if (number != 0) result += sign * number
        return result
    }
}