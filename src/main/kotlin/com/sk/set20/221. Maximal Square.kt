package com.sk.set20

class Solution221 {
    fun maximalSquare(A: Array<CharArray>): Int {
        val dp = Array(A.size) { IntArray(A[0].size) }

        fun findPrevious(r: Int, c: Int): Int {
            if (r !in A.indices || c !in A[0].indices) return 0
            return dp[r][c]
        }

        var ans = 0

        for (r in A.indices) {
            for (c in A[0].indices) {
                if (A[r][c] == '1') {
                    val l = findPrevious(r - 1, c - 1)
                    if (l == 0) {
                        dp[r][c] = 1
                    } else {
                        var cl = 0
                        for (ci in c downTo c - l) {
                            if (ci < 0) break
                            if (A[r][ci] != '1') break
                            cl++
                        }
                        var rl = 0
                        for (ri in r downTo r - l) {
                            if (ri < 0) break
                            if (A[ri][c] != '1') break
                            rl++
                        }
                        dp[r][c] = minOf(rl, cl)
                    }
                    ans = maxOf(ans, dp[r][c])
                }
            }
        }
        return ans * ans
    }
}