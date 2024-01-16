package com.sk.topicWise.dp.hard

class Solution123 {
    fun maxProfit(prices: IntArray): Int {
        var ans = 0
        for (i in 0 until prices.size) {
            var max1 = 0
            var profit1 = 0
            for (k in i downTo 0) {
                max1 = maxOf(max1, prices[k])
                profit1 = maxOf(profit1, max1 - prices[k])
            }
            var max2 = 0
            var profit2 = 0
            for (k in prices.lastIndex downTo i + 1) {
                max2 = maxOf(max2, prices[k])
                profit2 = maxOf(profit2, max2 - prices[k])
            }
            ans = maxOf(ans, profit1 + profit2)
        }
        return ans
    }

    // From DP formula from https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/solutions/135704/detail-explanation-of-dp-solution
    //
    /**
     * dp[k, i] = max(dp[k, i-1], prices[i] - prices[j] + dp[k-1, j-1]), j=[0..i-1]
     *
     * dp[k,i] - max profit at i with  k transactions
     *
     *
     */
    fun maxProfit2(prices: IntArray): Int {
        if (prices.isEmpty()) return 0
        val dp = Array(3) { IntArray(prices.size) }
        for (k in 1..2) {
            var min = prices[0]
            for (i in 1 until prices.size) {
                min = minOf(min, prices[i] - dp[k - 1][i - 1])
                dp[k][i] = maxOf(dp[k][i - 1], prices[i] - min)
            }
        }
        return dp[2][prices.size - 1]
    }


}