package com.sk.topicWise.stack

class Solution150 {
    fun evalRPN(tokens: Array<String>): Int {
        val s = ArrayDeque<Int>()
        for (token in tokens) {
            when (token) {
                "+" -> {
                    s.addLast(s.removeLast() + s.removeLast())
                }

                "-" -> {
                    val a = s.removeLast()
                    val b = s.removeLast()
                    s.addLast(b - a)
                }

                "*" -> {
                    s.addLast(s.removeLast() * s.removeLast())
                }

                "/" -> {
                    val a = s.removeLast()
                    val b = s.removeLast()
                    s.addLast(b / a)
                }

                else -> {
                    s.addLast(token.toInt())
                }
            }
        }
        return s.removeLast()
    }
}