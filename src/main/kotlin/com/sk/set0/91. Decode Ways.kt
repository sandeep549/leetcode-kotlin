package com.sk.set0

class Solution91 {
    fun numDecodings(s: String): Int {
        fun isValid(i: Int) = s[i] != '0'
        fun isValid(i: Int, j: Int) = (s[i] != '0' && s.substring(i, j + 1).toInt() <= 26)
        val dp = IntArray(s.length + 1) { -1 }
        dp[0] = if (s[0] == '0') 0 else 1

        fun ways(n: Int): Int {     //ways to decode til index n
            if (n < 0) return 1 // valid decoding when right part is valid and nothing left on left side
            if (dp[n] == -1) {
                var a = 0
                if (isValid(n)) a += ways(n - 1)
                if (isValid(n - 1, n)) a += ways(n - 2)
                dp[n] = a
            }
            return dp[n]
        }

        ways(s.lastIndex)
        return if (dp[s.lastIndex] == -1) 0 else dp[s.lastIndex]
    }

    fun numDecodings2(s: String): Int {
        val n = s.length
        val dp = IntArray(n + 1)
        dp[0] = 1
        dp[1] = if (s[0] != '0') 1 else 0
        for (i in 2..n) { // dp[k], ways to decode string of size k, i.e. upto length k-1
            val lastOne = Integer.valueOf(s.substring(i - 1, i))
            val lastTwo = Integer.valueOf(s.substring(i - 2, i))
            if (lastOne in 1..9) {
                dp[i] += dp[i - 1]
            }
            if (lastTwo in 10..26) {
                dp[i] += dp[i - 2]
            }
        }
        return dp[n]
    }

    fun numDecodings3(s: String): Int {
        val n = s.length
        val dp = IntArray(n + 1)
        var b = 1
        var a = if (s[0] != '0') 1 else 0
        for (i in 2..n) { // dp[k], ways to decode string of size k, i.e. upto length k-1
            val lastOne = Integer.valueOf(s.substring(i - 1, i))
            val lastTwo = Integer.valueOf(s.substring(i - 2, i))
            var t = 0
            if (lastOne in 1..9) {
                t += a
            }
            if (lastTwo in 10..26) {
                t += b
            }
            b = a
            a = t
        }
        return a
    }
}