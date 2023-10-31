package com.sk.topicWise.dp

class Solution1884 {
    fun twoEggDrop(n: Int): Int {
        val dp = IntArray(n + 1) { -1 }
        return drop(n, dp)
    }

    // Min drop required for n floors with 2 eggs
    private fun drop(n: Int, dp: IntArray): Int {
        if (dp[n] == -1) {
            for (i in 1..n) {
                val a = 1 + maxOf(i - 1, drop(n - i, dp)) // try drop at ith floor
                val b = if (dp[n] == -1) n else dp[n]
                dp[n] = minOf(a, b)
            }
        }
        return dp[n]
    }
}