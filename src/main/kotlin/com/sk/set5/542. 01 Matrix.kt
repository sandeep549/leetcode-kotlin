package com.sk.set5

class Solution542 {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val m = mat.size
        val n = mat[0].size
        val INF = m + n // The maximum possible distance in the matrix

        // First pass: Top-Left to Bottom-Right
        for (r in 0 until m) {
            for (c in 0 until n) {
                if (mat[r][c] != 0) {
                    val top = if (r > 0) mat[r - 1][c] else INF
                    val left = if (c > 0) mat[r][c - 1] else INF
                    mat[r][c] = minOf(top, left) + 1
                }
            }
        }

        // Second pass: Bottom-Right to Top-Left
        for (r in m - 1 downTo 0) {
            for (c in n - 1 downTo 0) {
                if (mat[r][c] != 0) {
                    val bottom = if (r < m - 1) mat[r + 1][c] else INF
                    val right = if (c < n - 1) mat[r][c + 1] else INF
                    mat[r][c] = minOf(mat[r][c], minOf(bottom, right) + 1)
                }
            }
        }

        return mat
    }

    fun updateMatrix2(mat: Array<IntArray>): Array<IntArray> {
        val m = mat.size
        val n = mat[0].size
        val INF = m + n // A value larger than the maximum possible distance
        val result = Array(m) { IntArray(n) { INF } }

        // First pass: Top-Left to Bottom-Right
        for (r in 0 until m) {
            for (c in 0 until n) {
                if (mat[r][c] == 0) {
                    result[r][c] = 0
                } else {
                    val top = if (r > 0) result[r - 1][c] else INF
                    val left = if (c > 0) result[r][c - 1] else INF
                    result[r][c] = minOf(top, left) + 1
                }
            }
        }

        // Second pass: Bottom-Right to Top-Left
        for (r in m - 1 downTo 0) {
            for (c in n - 1 downTo 0) {
                if (mat[r][c] != 0) {
                    val bottom = if (r < m - 1) result[r + 1][c] else INF
                    val right = if (c < n - 1) result[r][c + 1] else INF
                    result[r][c] = minOf(result[r][c], minOf(bottom, right) + 1)
                }
            }
        }

        return result
    }
}