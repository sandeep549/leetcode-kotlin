package com.sk.set15

class Solution1582 {
    fun numSpecial(mat: Array<IntArray>): Int {
        val row = IntArray(mat.size) { 0 }
        val col = IntArray(mat[0].size) { 0 }
        for (r in mat.indices) {
            for (c in mat[0].indices) {
                row[r] += if (mat[r][c] == 1) 1 else 0
                col[c] += if (mat[r][c] == 1) 1 else 0
            }
        }
        var count = 0
        for (r in mat.indices) {
            for (c in mat[0].indices) {
                if (mat[r][c] == 1 && row[r] == 1 && col[c] == 1) count++
            }
        }

        return count
    }
}