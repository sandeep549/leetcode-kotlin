package com.sk.topicWise.dp

class Solution97 {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        if (s1.length + s2.length != s3.length) return false
        if (s3.isEmpty()) return true
        val dp = Array(s3.length) { Array(s3.length) { IntArray(s3.length) { -1 } } }

        fun check(i: Int, j: Int, k: Int): Int {
            if (k == s3.length) return 1

            if (dp[i][j][k] == -1) {
                if (i < s1.length && j < s2.length &&
                    s1[i] == s3[k] && s2[j] == s3[k]
                ) {
                    var value = check(i + 1, j, k + 1)
                    if (value != 1) {
                        value = check(i, j + 1, k + 1)
                    }
                    dp[i][j][k] = value
                } else if (i < s1.length && s1[i] == s3[k]) {
                    dp[i][j][k] = check(i + 1, j, k + 1)
                } else if (j < s2.length && s2[j] == s3[k]) {
                    dp[i][j][k] = check(i, j + 1, k + 1)
                } else {
                    dp[i][j][k] = 0
                }
            }

            return dp[i][j][k]
        }

        return check(0, 0, 0) == 1
    }
}