package com.sk.medium


class Solution54 {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val res = ArrayList<Int>()
        var MIN_R = 0 // min available row
        var MIN_C = 0 // min available col
        var MAX_R = matrix.size - 1 // max available row
        var MAX_C = matrix[0].size - 1 // max available col
        var r = 0 // current row
        var c = 0 // current col

        while (true) {
            // go right
            while (c <= MAX_C) res.add(matrix[r][c++])
            c--
            MIN_R++
            r++
            if (MIN_R > MAX_R) break

            // go down
            while (r <= MAX_R) res.add(matrix[r++][c])
            r--
            MAX_C--
            c--
            if (MIN_C > MAX_C) break

            // go left
            while (c >= MIN_C) res.add(matrix[r][c--])
            c++
            MAX_R--
            r--
            if (MIN_R > MAX_R) break

            // go up
            while (r >= MIN_R) res.add(matrix[r--][c])
            r++
            MIN_C++
            c++
            if (MIN_C > MAX_C) break
        }
        return res
    }

    fun spiralOrder2(matrix: Array<IntArray>): List<Int> {
        val res = ArrayList<Int>()
        var top = 0 // top boundary
        var bottom = matrix.size - 1 // bottom boundary
        var left = 0 // left boundary
        var right = matrix[0].size - 1 // right boundary
        while (true) {
            // right
            for (i in left..right) res.add(matrix[top][i])
            top++
            if (top > bottom) break

            // down
            for (i in top..bottom) res.add(matrix[i][right])
            right--
            if (left > right) break

            // left
            for (i in right downTo left) res.add(matrix[bottom][i])
            bottom--
            if (top > bottom) break

            // up
            for (i in bottom downTo top) res.add(matrix[i][left])
            left++
            if (left > right) break
        }
        return res
    }
}