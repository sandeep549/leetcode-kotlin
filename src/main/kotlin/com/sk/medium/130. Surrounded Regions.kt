package com.sk.medium

class Solution130 {
    fun solve(board: Array<CharArray>): Unit {
        // mark all nodes with # which start from boundary
        for (c in board[0].indices) {
            dfs(0, c, board)
            dfs(board.lastIndex, c, board)
        }
        for (r in board.indices) {
            dfs(r, 0, board)
            dfs(r, board[0].lastIndex, board)
        }

        // Restore # to 0
        for (r in board.indices) {
            for (c in board[0].indices) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X'
                }
                if (board[r][c] == '#') {
                    board[r][c] = 'O'
                }
            }
        }
    }

    // Mark with # if reachable
    private fun dfs(r: Int, c: Int, board: Array<CharArray>) {
        if (r !in board.indices || c !in board[0].indices || board[r][c] == 'X' || board[r][c] == '#') return
        board[r][c] = '#'
        dfs(r + 1, c, board)
        dfs(r - 1, c, board)
        dfs(r, c - 1, board)
        dfs(r, c + 1, board)
    }

}