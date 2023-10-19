package com.sk.leetcode.easy


class Solution20 {

    fun isValid(s: String): Boolean {
        val map = hashMapOf('(' to ')', '{' to '}', '[' to ']')
        val stack = ArrayDeque<Char>()
        for (c in s.toCharArray()) {
            if (map.containsKey(c)) stack.addLast(map[c]!!)
            else if (stack.isEmpty() || stack.removeLast() != c) return false
        }
        return stack.isEmpty()
    }

    fun isValid3(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        for (c in s.toCharArray()) {
            if (c == '(')
                stack.addLast(')')
            else if (c == '{')
                stack.addLast('}')
            else if (c == '[')
                stack.addLast(']')
            else if (stack.isEmpty() || stack.removeLast() != c)
                return false
        }
        return stack.isEmpty()
    }

    fun isValid2(s: String): Boolean {
        val open = setOf('(', '{', '[')
        val map = mutableMapOf(
            '(' to ')',
            '{' to '}',
            '[' to ']'
        )
        val stack = ArrayDeque<Char>()
        for (ch in s) {
            if (open.contains(ch)) {
                stack.addLast(ch)
            } else {
                if (stack.isNotEmpty() && map[stack.last()] == ch) {
                    stack.removeLast()
                } else {
                    return false
                }
            }
        }
        return stack.isEmpty()
    }
}