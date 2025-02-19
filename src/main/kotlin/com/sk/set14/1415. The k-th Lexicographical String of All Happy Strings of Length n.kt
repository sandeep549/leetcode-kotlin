package com.sk.set14

class Solution1415 {
    fun getHappyString(n: Int, k: Int): String {
        val result = mutableListOf<String>()
        val chars = charArrayOf('a', 'b', 'c')
        generateHappyStrings(n, "", chars, result)

        return if (k <= result.size) result[k - 1] else ""
    }

    private fun generateHappyStrings(n: Int, current: String, chars: CharArray, result: MutableList<String>) {
        if (current.length == n) {
            result.add(current)
            return
        }
        for (ch in chars) {
            if (current.isEmpty() || current.last() != ch) {
                generateHappyStrings(n, current + ch, chars, result)
            }
        }
    }
}