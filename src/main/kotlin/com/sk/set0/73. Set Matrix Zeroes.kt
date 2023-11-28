package com.sk.set0

class Solution73 {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val row = HashSet<Int>()
        val cols = HashSet<Int>()
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if (matrix[i][j] == 0) {
                    row.add(i)
                    cols.add(j)
                }
            }
        }

        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                if (row.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0
                }
            }
        }
    }

    fun setZeroes2(matrix: Array<IntArray>) {
        var isCol = false
        val R = matrix.size
        val C = matrix[0].size
        for (i in 0 until R) {
            if (matrix[i][0] == 0) { // (0,0) will overlap, so it will tell row values, take variable for col values
                isCol = true
            }
            for (j in 1 until C) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0 // set state in first row, means this col is all zero
                    matrix[i][0] = 0 // set state in first column, means this row is all zero
                }
            }
        }

        for (i in 1 until R) {
            for (j in 1 until C) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0
                }
            }
        }

        // Handle first row
        if (matrix[0][0] == 0) {
            for (j in 0 until C) {
                matrix[0][j] = 0
            }
        }

        // Handle first column
        if (isCol) {
            for (i in 0 until R) {
                matrix[i][0] = 0
            }
        }
    }

}
