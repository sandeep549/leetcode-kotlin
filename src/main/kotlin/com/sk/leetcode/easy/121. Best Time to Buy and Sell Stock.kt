package com.sk.leetcode.easy

class Solution121 {
    fun maxProfit(prices: IntArray): Int {
        var max = 0
        for (i in 0 until prices.lastIndex) {
            for (j in i+1 until prices.size) {
                max = maxOf(max, prices[j] - prices[i])
            }
        }
        return max
    }

    fun maxProfit2(prices: IntArray): Int {
        var minSoFar = prices[0]
        var ans = 0
        for (i in 1 until prices.size) {
            ans = maxOf(ans, prices[i] - minSoFar)
            minSoFar = minOf(minSoFar, prices[i])
        }
        return ans
    }
}

fun main() {
    val sol = Solution121()
    println(sol.maxProfit(intArrayOf(1,2)))
}
