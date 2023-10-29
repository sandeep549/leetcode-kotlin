package com.sk.topicWise.dp

class Solution70 {
    // top-down
    fun climbStairs(n: Int): Int {
        val dp = IntArray(n + 1) { -1 }
        return ways(n, dp)
    }

    private fun ways(n: Int, dp: IntArray): Int {
        if (n == 0 || n == 1) return 1
        if (dp[n] == -1) {
            dp[n] = ways(n - 1, dp) + ways(n - 2, dp)
        }
        return dp[n]
    }

    // bottom-up
    fun climbStairs2(n: Int): Int {
        // Say we want to reach first step, i.e. 1, then it must result in 1
        // f(1) = f(0) + f(-1) => f(0) = 1 and f(-1) = 0
        var a = 0 // ways to reach at curr-2, 0th -1 step
        var b = 1 // ways to reach at cur-1, 0th step
        var c = 0 // ways to reach at current step
        for (i in 1..n) {
            c = a + b
            a = b
            b = c
        }
        return c
    }

}

