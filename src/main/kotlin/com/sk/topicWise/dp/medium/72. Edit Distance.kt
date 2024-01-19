package com.sk.topicWise.dp.medium

class Solution72 {

    // https://leetcode.com/problems/edit-distance/solutions/25895/step-by-step-explanation-of-how-to-optimize-the-solution-from-simple-recursion-to-dp

    /**
     * Top-down
     */
    fun minDistance(word1: String, word2: String): Int {
        if (word1.isEmpty()) return word2.length
        if (word2.isEmpty()) return word1.length

        val c1 = word1.toCharArray()
        val c2 = word2.toCharArray()
        val cache = Array(c1.size) { IntArray(c2.size) { -1 } }

        // Min operation required at index i & j
        fun match(c1: CharArray, c2: CharArray, i: Int, j: Int): Int {
            if (c1.size == i) return c2.size - j
            if (c2.size == j) return c1.size - i

            if (cache[i][j] == -1) {
                if (c1[i] == c2[j]) {
                    cache[i][j] = match(c1, c2, i + 1, j + 1) // no operation needed at these indexes, go to next index
                } else {
                    //Case1: insert
                    val insert = match(c1, c2, i, j + 1)
                    //Case2: delete
                    val delete = match(c1, c2, i + 1, j)
                    //Case3: replace
                    val replace = match(c1, c2, i + 1, j + 1)
                    cache[i][j] = minOf(insert, delete, replace) + 1
                }
            }

            return cache[i][j]
        }

        return match(c1, c2, 0, 0)
    }

    /**
     * Bottom-up approach
     */
    fun minDistance2(word1: String, word2: String): Int {
        if (word1.isEmpty()) return word2.length
        if (word2.isEmpty()) return word1.length

        val c1 = word1.toCharArray()
        val c2 = word2.toCharArray()
        val matched = Array(c1.size + 1) { IntArray(c2.size + 1) }

        //matched[length of c1 already been matched][length of c2 already been matched]
        for (i in 0..c1.size) {
            matched[i][0] = i
        }
        for (j in 0..c2.size) {
            matched[0][j] = j
        }

        for (i in c1.indices) {
            for (j in c2.indices) {
                if (c1[i] == c2[j]) {
                    matched[i + 1][j + 1] = matched[i][j]
                } else {
                    matched[i + 1][j + 1] = minOf(
                        matched[i][j + 1], // i is deleted
                        matched[i + 1][j], // insert at j
                        matched[i][j] // both j is replaced
                    ) + 1
                    //Since it is bottom up, we are considering in the ascending order of indexes.
                    //Insert means plus 1 to j, delete means plus 1 to i, replace means plus 1 to both i and j.
                    //above sequence is delete, insert and replace.
                }
            }
        }
        return matched[c1.size][c2.size]
    }
}
