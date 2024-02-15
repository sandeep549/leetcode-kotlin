package com.sk.topicWise.dp

import kotlin.math.max

class Solution516 {
    fun longestPalindromeSubseq(s: String): Int {
        val dp = Array(s.length) { IntArray(s.length){ -1 } }
        fun find(l: Int, r: Int): Int { // find max palindrome subsequence in [l,r]
            if(l > r) return 0
            if(l == r) return 1
            if(dp[l][r] == -1) {
                if(s[l] == s[r]) {
                    dp[l][r] = find(l+1, r-1) + 2
                } else {
                    dp[l][r] = maxOf(find(l, r-1), find(l+1, r))
                }
            }
            return dp[l][r]
        }
        return find(0, s.length-1)
    }

    fun longestPalindromeSubseq2(s: String): Int {
        val dp = Array(s.length) { IntArray(s.length) }
        for (i in s.lastIndex downTo 0) {
            dp[i][i] = 1
            for (j in i+1 until s.length) {
                if (s[i] == s[j]) {
                    dp[i][j] = dp[i+1][j-1] + 2
                } else {
                    dp[i][j] = maxOf(dp[i][j-1], dp[i+1][j])
                }
            }
        }
        return dp[0][s.length-1]
    }
}
