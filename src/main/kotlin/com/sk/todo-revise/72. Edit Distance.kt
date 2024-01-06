package com.sk.`todo-revise`

class Solution72 {

    // https://leetcode.com/problems/edit-distance/solutions/25895/step-by-step-explanation-of-how-to-optimize-the-solution-from-simple-recursion-to-dp
    fun minDistance(word1: String, word2: String): Int {
        if (word1.isEmpty()) return word2.length
        if (word2.isEmpty()) return word1.length
        val c1 = word1.toCharArray()
        val c2 = word2.toCharArray()
        val cache = Array(c1.size) { IntArray(c2.size) }
        for (i in c1.indices) {
            for (j in c2.indices) {
                cache[i][j] = -1
            }
        }

        fun match(c1: CharArray, c2: CharArray, i: Int, j: Int): Int {
            if (c1.size == i) return c2.size - j
            if (c2.size == j) return c1.size - i

            if (cache[i][j] == -1) {
                if (c1[i] == c2[j]) {
                    cache[i][j] = match(c1, c2, i + 1, j + 1)
                } else {
                    //Case1: insert
                    val insert = match(c1, c2, i, j + 1)
                    //Case2: delete
                    val delete = match(c1, c2, i + 1, j)
                    //Case3: replace
                    val replace = match(c1, c2, i + 1, j + 1)
                    cache[i][j] = Math.min(Math.min(insert, delete), replace) + 1
                }
            }

            return cache[i][j]
        }

        return match(c1, c2, 0, 0)
    }

}
