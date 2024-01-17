package com.sk.`todo-revise`

class Solution188 {
    fun maxProfit(k: Int, prices: IntArray): Int {
        if (prices.isEmpty()) return 0
        val dp = Array(k + 1) { IntArray(prices.size) }
        for (t in 1..k) {
            var min = prices[0]
            for (i in 1 until prices.size) {
                min = minOf(min, prices[i] - dp[t - 1][i - 1])
                dp[t][i] = maxOf(dp[t][i - 1], prices[i] - min)
            }
        }
        return dp[k][prices.size - 1]
    }
}