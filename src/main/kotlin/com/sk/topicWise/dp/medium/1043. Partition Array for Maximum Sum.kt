package com.sk.topicWise.dp.medium

class Solution1043 {
    fun maxSumAfterPartitioning(arr: IntArray, k: Int): Int {
        val dp = IntArray(arr.size) { -1 }

        fun maxFromCurrentPart(s: Int, e: Int): Int {
            val start = maxOf(0, s)
            val end = e
            return arr.slice(start..end).max() * (end - start + 1)
        }

        fun maxAt(A: IntArray, i: Int): Int {
            if (i < 0) return 0
            if (dp[i] != -1) return dp[i]
            var maxhere = 0
            for (len in 1..k) {
                maxhere = maxOf(
                    maxhere, maxAt(A, i - len) + maxFromCurrentPart(i - len + 1, i)
                )
            }
            dp[i] = maxhere
            return dp[i]
        }

        return maxAt(arr, arr.lastIndex)
    }

    fun maxSumAfterPartitioning2(A: IntArray, K: Int): Int {
        val dp = IntArray(A.size + 1)
        for (i in 1..A.size) {
            var curMax = 0
            var best = 0
            var k = 1
            while (k <= K && i - k >= 0) {
                curMax = maxOf(curMax, A[i - k])
                best = maxOf(best, dp[i - k] + curMax * k)
                ++k
            }
            dp[i] = best
        }
        return dp[A.size]
    }

}