package com.sk.topicWise.dp.medium

import kotlin.math.max

class Solution343 {
    fun integerBreak(n: Int): Int {
        val dp = IntArray(n + 1) { -1 }
        fun max(n: Int): Int {
            if (n == 1) return 1
            if (dp[n] == -1) {
                var l = 1
                var r = n - 1
                var m = 0
                while (l <= r) {
                    val a = maxOf(l, max(l))
                    val b = maxOf(r, max(r))
                    m = maxOf(m, a * b)
                    l++
                    r--
                }
                dp[n] = m
            }
            return dp[n]
        }
        return max(n)
    }

    fun integerBreak2(n: Int): Int {
        val dp = IntArray(n+1)
        dp[1] = 1
        for (i in 2..n) {
            var l = 1
            var r = i-1
            var m = 0
            while (l <= r) {
                val a = maxOf(l, dp[l])
                val b = max(r, dp[r])
                m = maxOf(m, a*b)
                l++
                r--
            }
            dp[i] = m
        }
        return dp[n]
    }
}