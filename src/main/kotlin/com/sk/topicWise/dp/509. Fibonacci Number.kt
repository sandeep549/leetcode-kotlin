package com.sk.topicWise.dp

class Solution509 {

    // dp, bottom-up
    fun fib(n: Int): Int {
        if (n == 0 || n == 1) return n
        var a = 0
        var b = 1
        for (i in 2..n) {
            val c = a + b
            a = b
            b = c
        }
        return b
    }

    // dp, top-down
    fun fib2(N: Int): Int {
        val dp = IntArray(N + 1)
        fun recur(n: Int): Int {
            if (n == 0 || n == 1) return n
            if (dp[n] == 0) {
                dp[n] = recur(n - 1) + recur(n - 2)
            }
            return dp[n]
        }
        return recur(N)
    }

    // recursion
    fun fib3(N: Int): Int {
        if (N == 0 || N == 1) return N
        return fib(N - 1) + fib(N - 2)
    }
}

