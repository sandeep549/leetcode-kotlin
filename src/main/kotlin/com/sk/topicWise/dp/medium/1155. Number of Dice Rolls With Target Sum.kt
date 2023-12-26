package com.sk.topicWise.dp.medium

class Solution1155 {
    fun numRollsToTarget(n: Int, k: Int, target: Int): Int {
        val M = 1_000_000_007
        val arr = Array(n + 1) { IntArray(target + 1) { -1 } }

        fun ways(n: Int, target: Int): Int {
            if (target < 0 || n <= 0) return 0
            if (n == 1 && target in 1..k) return 1
            if (arr[n][target] == -1) {
                var ways = 0
                for (s in 1..k) {
                    val w = (ways(n - 1, target - s) % M)
                    ways = (ways + w) % M
                }
                arr[n][target] = ways
            }
            return arr[n][target]
        }

        return ways(n, target)
    }
}