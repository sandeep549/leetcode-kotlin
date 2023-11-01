package com.sk.leetcode.kotlin

class Solution122 {
    /**
     * Consider each greater element compared to previous and keep accumulating delta profit.
     */
    fun maxProfit(prices: IntArray): Int {
        var res = 0
        for (i in 1 until prices.size) {
            if (prices[i] > prices[i - 1]) {
                res += (prices[i] - prices[i - 1])
            }
        }
        return res
    }

    /**
     * Traverse from left to right, find every peak followed by valley, and
     * book profit. Keep accumulating the profit and return it.
     */
    fun maxProfit2(prices: IntArray): Int {
        var valley = 0
        var peak = 0
        var profit = 0
        var i = 0
        while (i < prices.size - 1) {
            // going down till we find a valley
            while (i < prices.size - 1 && prices[i + 1] <= prices[i]) i++
            valley = prices[i]

            // going up till we find a peak
            while (i < prices.size - 1 && prices[i + 1] >= prices[i]) i++
            peak = prices[i]

            // time to book profit
            profit += peak - valley
        }
        return profit
    }
}



