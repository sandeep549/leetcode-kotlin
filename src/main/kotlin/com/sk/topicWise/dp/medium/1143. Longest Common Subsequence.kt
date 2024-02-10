package com.sk.topicWise.dp.medium

class Solution1143 {
    fun longestCommonSubsequence(a: String, b: String): Int {
        val m = Array(a.length + 1) { IntArray(b.length + 1) }
        for (i in a.indices) {
            for (j in b.indices) {
                m[i + 1][j + 1] = if (a[i] == b[j]) m[i][j] + 1 else maxOf(m[i + 1][j], m[i][j + 1])
            }
        }
        return m[a.length][b.length]
    }
}