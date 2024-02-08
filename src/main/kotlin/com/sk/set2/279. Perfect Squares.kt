package com.sk.set2

class Solution279 {
    fun numSquares(n: Int): Int {
        val dp = IntArray(n + 1) { Int.MAX_VALUE }
        dp[0] = 0
        for (i in 1..n) {
            var min = Int.MAX_VALUE
            var j = 1
            while (i - j * j >= 0) {
                min = minOf(min, dp[i - j * j] + 1)
                ++j
            }
            dp[i] = min
        }
        return dp[n]
    }
}


private fun numSquares(n: Int): Int {
    val dp = IntArray(n + 1)
    fun find(x: Int): Int {
        if (x < 4) return x
        if (dp[x] != 0) return dp[x]
        var min = x
        var i = 1
        while (i * i <= x) {
            min = minOf(min, find(x - i * i) + 1)
            i++
        }
        dp[x] = min
        return min
    }
    return find(n)
}

private fun numSquares2(n: Int): Int {
    if (n < 4) return n
    var count = n // as we can form number n with sum of atleqast n 1's.
    var i = 1
    while (i * i <= n) {
        count = minOf(count, numSquares(n - i * i) + 1)
        i++
    }
    return count
}