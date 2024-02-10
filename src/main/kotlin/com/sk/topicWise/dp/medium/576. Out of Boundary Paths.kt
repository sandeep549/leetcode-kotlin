package com.sk.topicWise.dp.medium

class Solution576 {

    fun findPaths(m: Int, n: Int, maxMove: Int, i: Int, j: Int): Int {
        if (maxMove <= 0) return 0
        val MOD = 1e9.toInt() + 7
        val table = Array(maxMove + 1) { Array(m) { IntArray(n) } }
        table[0][i][j] = 1 // base case, move required to come here
        var ans = 0
        val dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))

        for (step in 1..maxMove) {
            for (r in 0 until m) {
                for (c in 0 until n) {
                    for (d in dirs) {
                        val nr = r + d[0]
                        val nc = c + d[1]
                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                            ans = (ans + table[step - 1][r][c]) % MOD
                        } else {
                            table[step][nr][nc] = (table[step][nr][nc] + table[step - 1][r][c]) % MOD
                        }
                    }
                }
            }
        }
        return ans
    }

    fun findPaths2(m: Int, n: Int, maxMove: Int, i: Int, j: Int): Int {
        if (maxMove <= 0) return 0
        val MOD = 1e9.toInt() + 7
        var count = Array(m) { IntArray(n) }
        count[i][j] = 1 // base case, move required to come here
        var ans = 0
        val dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))

        for (step in 0 until maxMove) {
            val temp = Array(m) { IntArray(n) }
            for (r in 0 until m) {
                for (c in 0 until n) {
                    for (d in dirs) {
                        val nr = r + d[0]
                        val nc = c + d[1]
                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                            ans = (ans + count[r][c]) % MOD
                        } else {
                            temp[nr][nc] = (temp[nr][nc] + count[r][c]) % MOD
                        }
                    }
                }
            }
            count = temp
        }

        return ans
    }
}