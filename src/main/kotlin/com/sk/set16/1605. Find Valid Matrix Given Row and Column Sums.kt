package com.sk.set16

class Solution1605 {
    fun restoreMatrix(rowSum: IntArray, colSum: IntArray): Array<IntArray> {
        val R = rowSum.size
        val C = colSum.size
        val matrix = Array(R) { IntArray(C) }
        for (r in 0 until R) {
            for (c in 0 until C) {
                matrix[r][c] = minOf(rowSum[r], colSum[c])
                rowSum[r] -= matrix[r][c]
                colSum[c] -= matrix[r][c]
            }
        }
        return matrix
    }
}