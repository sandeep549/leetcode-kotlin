package com.sk.medium

class Solution36 {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val seen = HashSet<String>()
        for (i in 0 until 9) {
            for (j in 0 until 9) {
                val number = board[i][j]
                if (number != '.') {
                    // Return false if we are not able to add any of row, col or block
                    if (!seen.add("$number in row $i") ||
                        !seen.add("$number in column $j") ||
                        !seen.add("$number in block " + i / 3 + "-" + j / 3)
                    ) {
                        return false
                    }
                }
            }
        }
        return true
    }
}