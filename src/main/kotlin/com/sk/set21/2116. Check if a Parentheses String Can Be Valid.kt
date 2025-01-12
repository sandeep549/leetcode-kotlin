package com.sk.set21

class Solution2116 {

    fun canBeValid(s: String, locked: String): Boolean {
        val length = s.length

        if (length % 2 == 1) return false

        val openBrackets = ArrayDeque<Int>()
        val unlocked = ArrayDeque<Int>()

        for (i in 0 until length) {
            when {
                locked[i] == '0' -> unlocked.add(i)
                s[i] == '(' -> openBrackets.add(i)
                s[i] == ')' -> {
                    if (openBrackets.isNotEmpty()) {
                        openBrackets.removeLast()
                    } else if (unlocked.isNotEmpty()) {
                        unlocked.removeLast()
                    } else {
                        return false
                    }
                }
            }
        }

        // Match remaining open brackets with unlocked characters
        while (openBrackets.isNotEmpty() && unlocked.isNotEmpty() && openBrackets.last() < unlocked.last()) {
            openBrackets.removeLast()
            unlocked.removeLast()
        }

        return openBrackets.isEmpty()
    }
}