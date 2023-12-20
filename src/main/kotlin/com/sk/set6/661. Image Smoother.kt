package com.sk.set6

class Solution661 {
    fun imageSmoother(M: Array<IntArray>): Array<IntArray> {
        val m = M.size
        val n = M[0].size
        if (n == 0) return arrayOf()
        val dirs = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, -1),
            intArrayOf(1, 0),
            intArrayOf(-1, 0),
            intArrayOf(-1, -1),
            intArrayOf(1, 1),
            intArrayOf(-1, 1),
            intArrayOf(1, -1)
        )
        for (i in 0 until m) {
            for (j in 0 until n) {
                var sum = M[i][j]
                var cnt = 1
                for (k in dirs.indices) {
                    val x = i + dirs[k][0]
                    val y = j + dirs[k][1]
                    if (x < 0 || x > m - 1 || y < 0 || y > n - 1) continue
                    sum += (M[x][y] and 0xFF)
                    cnt++
                }
                M[i][j] = (M[i][j] or ((sum / cnt) shl 8))
            }
        }
        for (i in 0 until m) {
            for (j in 0 until n) {
                M[i][j] = M[i][j] shr 8
            }
        }
        return M
    }

}