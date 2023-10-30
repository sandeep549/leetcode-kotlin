package com.sk.topicWise.dp

class Solution1137 {
    fun tribonacci(n: Int): Int {
        if (n == 0) return 0
        var a = 0
        var b = 1
        var c = 1
        for (i in 3..n) {
            val d = a + b + c
            a = b
            b = c
            c = d
        }
        return c
    }
}

// dp, bottom-up
private fun tribonacci(n: Int): Int {
    if (n == 0) return 0
    var t0 = 0
    var t1 = 1
    var t2 = 1
    for (i in 3..n) {
        val s = t2 + t1 + t0
        t0 = t1
        t1 = t2
        t2 = s
    }
    return t2
}

// dp, top-down
private fun tribonacci2(n: Int): Int {
    val dp = IntArray(n + 1) { 0 }
    fun calc(n: Int): Int {
        if (n <= 0) return 0
        if (n <= 2) return 1
        if (dp[n] == 0) {
            dp[n] = calc(n - 1) + calc(n - 2) + calc(n - 3)
        }
        return dp[n]
    }
    return calc(n)
}
