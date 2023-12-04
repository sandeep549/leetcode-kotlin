package com.sk.set0

class Solution79 {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        for (r in board.indices) {
            for (c in board[0].indices) {
                if (find(board, word, 0, r, c)) return true
            }
        }
        return false
    }

    private fun find(
        board: Array<CharArray>,
        word: String, i: Int, r: Int, c: Int
    ): Boolean {
        if (i == word.length) return true
        if (r !in board.indices || c !in 0..<board[0].size) return false

        if (board[r][c] == word[i]) {
            board[r][c] = '*' // mark visited
            val left = find(board, word, i + 1, r, c - 1)
            val right = find(board, word, i + 1, r, c + 1)
            val up = find(board, word, i + 1, r - 1, c)
            val down = find(board, word, i + 1, r + 1, c)
            board[r][c] = word[i] // restore
            return left || right || up || down
        } else {
            return false
        }
    }
}


