package com.sk.medium


class Solution935 {

    /**
     * DP top-down
     */
    val max = 1e9.toInt() + 7
    fun knightDialer(n: Int): Int {
        var s = 0L
        val dp = Array(n + 1) { Array(4) { LongArray(3) } }

        for (i in 0 until 4) {
            for (j in 0 until 3) {
                s = (s + ways(i, j, n, dp)) % max
            }
        }
        return s.toInt()
    }

    private fun ways(i: Int, j: Int, n: Int, dp: Array<Array<LongArray>>): Long {
        if (i < 0 || i > 3 || j < 0 || j > 2 || (i == 3 && j != 1)) return 0

        if (n == 1) return 1 // base case

        if (dp[n][i][j] == 0L) {
            dp[n][i][j] = ways(i - 1, j - 2, n - 1, dp) % max +
                    ways(i - 1, j + 2, n - 1, dp) % max +
                    ways(i + 1, j - 2, n - 1, dp) % max +
                    ways(i + 1, j + 2, n - 1, dp) % max +
                    ways(i - 2, j - 1, n - 1, dp) % max +
                    ways(i + 2, j - 1, n - 1, dp) % max +
                    ways(i - 2, j + 1, n - 1, dp) % max +
                    ways(i + 2, j + 1, n - 1, dp) % max

        }

        return dp[n][i][j]
    }


//    /**
//     * dp bottom up
//     */
//    fun knightDialer2(n: Int): Int {
//        var dp = Array(4) { LongArray(3) }
//
//        for (k in 1..n) {
//            val dp1 = Array(4) { LongArray(3) }
//            for (i in 0 until 4) {
//                for (j in 0 until 3) {
//                    // ways to get here(i,j) from 8 different location using k-1 steps
//                    dp1[i][j] = ways(i, j, dp)
//                }
//            }
//            dp = dp1
//        }
//
//        var s = 0L
//        for (i in 0 until 4) {
//            for (j in 0 until 3) {
//                s = (s + dp[i][j]) % max
//            }
//        }
//        return s.toInt()
//    }
//
//    // No of ways to come at r,c
//    private fun ways(r: Int, c: Int, dp: Array<LongArray>): Long {
//        var s = 0L
//        if (r + 1 <= 3) {
//            if (c - 2 >= 0) s = (s + dp[r + 1][c - 2]) % max
//            if (c + 2 <= 2) s = (s + dp[r + 1][c + 2]) % max
//        }
//        if (r - 1 >= 0) {
//            if (c - 2 >= 0) s = (s + dp[r - 1][c - 2]) % max
//            if (c + 2 <= 2) s = (s + dp[r - 1][c + 2]) % max
//        }
//        if (c + 1 <= 2) {
//            if (r - 2 >= 0) s = (s + dp[r - 2][c + 1]) % max
//            if (r + 2 <= 3) s = (s + dp[r + 2][c + 1]) % max
//        }
//        if (c - 1 >= 0) {
//            if (r - 2 >= 0) s = (s + dp[r - 2][c - 1]) % max
//            if (r + 2 <= 3) s = (s + dp[r + 2][c - 1]) % max
//        }
//
//        return s
//    }
//

}