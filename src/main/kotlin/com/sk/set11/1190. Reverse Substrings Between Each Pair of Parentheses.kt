package com.sk.set11

class Solution1190 {
    fun reverseParentheses(s: String): String {
        val stack = ArrayDeque<Char>()
        for(ch in s.toCharArray()) {
            when(ch) {
                ')' -> {
                    val list = mutableListOf<Char>()
                    while (stack.last() != '(') {
                        list.add(stack.removeLast())
                    }
                    stack.removeLast() // remove '('
                    stack.addAll(list)
                }
                else -> {
                    stack.addLast(ch)
                }
            }
        }
        return stack.joinToString(separator = "")
    }
}