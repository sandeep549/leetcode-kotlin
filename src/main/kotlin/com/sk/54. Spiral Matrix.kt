package com.sk

private fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    val res = mutableListOf<Int>()
    var MIN_R = 0
    var MIN_C = 0
    var MAX_R = matrix.size - 1
    var MAX_C = matrix[0].size - 1
    var r = 0
    var c = 0
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