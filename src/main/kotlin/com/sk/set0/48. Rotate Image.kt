package com.sk.set0

private fun rotate(matrix: Array<IntArray>) {
    val n = matrix.size
    for (i in 0 until (n + 1) / 2) {
        for (j in 0 until n / 2) {
            val temp = matrix[n - 1 - j][i]
            matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1]
            matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i]
            matrix[j][n - 1 - i] = matrix[i][j]
            matrix[i][j] = temp
        }
    }
}

class Solution48 {
    // https://javabypatel.blogspot.com/2016/11/rotate-matrix-by-90-degrees-inplace.html
    fun rotate(matrix: Array<IntArray>) {
        val length = matrix.size - 1
        for (i in 0..length / 2) {
            for (j in i until length - i) {
                //Coordinate 1
                val p1 = matrix[i][j]
                //Coordinate 2
                val p2 = matrix[j][length - i]
                //Coordinate 3
                val p3 = matrix[length - i][length - j]
                //Coordinate 4
                val p4 = matrix[length - j][i]
                //Swap values of 4 coordinates.
                matrix[j][length - i] = p1
                matrix[length - i][length - j] = p2
                matrix[length - j][i] = p3
                matrix[i][j] = p4
            }
        }
    }

    /**
     * https://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/#:~:text=Example%20no%202%20%E2%80%93%20Inplace%20rotate%20square%20matrix%20by%2090%20degrees%20by%20transposing%20and%20reversing%20the%20matrix
     * https://www.khanacademy.org/math/linear-algebra/matrix-transformations/matrix-transpose/v/linear-algebra-transpose-of-a-matrix
     * https://www.youtube.com/watch?v=9hOSQXIMxgc&ab_channel=Udacity
     */
    fun rotate2(matrix: Array<IntArray>) {
        // Transpose the matrix
        for (i in matrix.indices) {
            for (j in i + 1 until matrix[0].size) {
                matrix[i][j] = matrix[j][i].also { matrix[j][i] = matrix[i][j] }
            }
        }
        // Reverse individual each row
        for (i in matrix.indices) {
            var l = 0
            var r = matrix[0].size - 1
            while (l < r) {
                matrix[i][l] = matrix[i][r].also { matrix[i][r] = matrix[i][l] }
                l++
                r--
            }
        }
    }
}