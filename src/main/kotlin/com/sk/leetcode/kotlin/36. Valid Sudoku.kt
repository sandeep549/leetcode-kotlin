package com.sk.leetcode.kotlin

private fun isValidSudoku(board: Array<CharArray>): Boolean {
    val seen = mutableSetOf<String>()
    for (i in 0..8) {
        for (j in 0..8) {
            val number = board[i][j]
            if (number != '.') {
                if (!seen.add("$number in row $i") ||
                    !seen.add("$number in column $j") ||
                    !seen.add(number.toString() + " in block " + i / 3 + "-" + j / 3)
                ) return false
            }
        }
    }
    return true
}