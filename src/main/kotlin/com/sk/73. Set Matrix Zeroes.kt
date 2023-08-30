package com.sk

private fun setZeroes(matrix: Array<IntArray>) {
    var isCol = false
    val R = matrix.size
    val C: Int = matrix[0].size
    for (i in 0 until R) {

        if (matrix[i][0] == 0) {
            isCol = true
        }
        for (j in 1 until C) {
            if (matrix[i][j] == 0) {
                matrix[0][j] = 0
                matrix[i][0] = 0
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

    if (matrix[0][0] == 0) {
        for (j in 0 until C) {
            matrix[0][j] = 0
        }
    }

    if (isCol) {
        for (i in 0 until R) {
            matrix[i][0] = 0
        }
    }
}
