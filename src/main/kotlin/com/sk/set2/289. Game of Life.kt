package com.sk.set2

private fun gameOfLife(board: Array<IntArray>) {
    val neighbors = intArrayOf(0, 1, -1)
    val rows = board.size
    val cols: Int = board[0].size

    val copyBoard = Array(rows) { IntArray(cols) }
    for (row in 0 until rows) {
        for (col in 0 until cols) {
            copyBoard[row][col] = board[row][col]
        }
    }

    for (row in 0 until rows) {
        for (col in 0 until cols) {
            var liveNeighbors = 0
            for (i in 0..2) {
                for (j in 0..2) {
                    if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                        val r = row + neighbors[i]
                        val c = col + neighbors[j]

                        if (r in 0 until rows && c in 0 until cols && copyBoard[r][c] == 1) liveNeighbors++
                    }
                }
            }

            // Rule 1 or Rule 3
            if (copyBoard[row][col] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                board[row][col] = 0
            }
            // Rule 4
            if (copyBoard[row][col] == 0 && liveNeighbors == 3) {
                board[row][col] = 1
            }
        }
    }
}

private fun gameOfLife2(board: Array<IntArray>?) {
    if (board == null || board.isEmpty()) return
    val r = board.size
    val c: Int = board[0].size

    fun liveNeighbors(board: Array<IntArray>, m: Int, n: Int, i: Int, j: Int): Int {
        var lives = 0
        for (x in maxOf(i - 1, 0)..minOf(i + 1, m - 1)) {
            for (y in maxOf(j - 1, 0)..minOf(j + 1, n - 1)) {
                lives += board[x][y] and 1
            }
        }
        lives -= board[i][j] and 1
        return lives
    }

    for (i in 0 until r) {
        for (j in 0 until c) {
            val lives = liveNeighbors(board, r, c, i, j)

            // In the beginning, every 2nd bit is 0;
            // So we only need to care about when will the 2nd bit become 1.    if (board == null || board.isEmpty()) return
            //     val m = board.size
            //     val n: Int = board[0].size
            if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
                board[i][j] = 3 // Make the 2nd bit 1: 01 ---> 11
            }
            if (board[i][j] == 0 && lives == 3) {
                board[i][j] = 2 // Make the 2nd bit 1: 00 ---> 10
            }
        }
    }
    for (i in 0 until r) {
        for (j in 0 until c) {
            board[i][j] = board[i][j] shr 1 // Get the 2nd state.
        }
    }
}

class Solution289 {
    /**
     * Go over matrix and check every cell situation for next generation using 8 neighbours.
     * If this cell is supposed to change then do -2 for it, to make it negative
     * Otherwise, don't change as it's not supposed to change in next generation.
     *
     * Go over matrix again, if value is negative then, flip it
     */
    fun gameOfLife(board: Array<IntArray>): Unit {
        for (r in board.indices) {
            for (c in board[0].indices) {
                val cur = board[r][c]
                val live = liveNeighbour(board, r, c)
                when {
                    cur == 1 && live < 2 -> {
                        board[r][c] -= 2 // It has to flip
                    }

                    cur == 1 && (live == 2 || live == 3) -> {
                        // No flip, No change
                    }

                    cur == 1 && live > 3 -> {
                        board[r][c] -= 2 // It has to flip
                    }

                    cur == 0 && live == 3 -> {
                        board[r][c] -= 2 // It has to flip
                    }
                }
            }
        }

        for (r in board.indices) {
            for (c in board[0].indices) {
                if (board[r][c] < 0) {
                    board[r][c] += 2 // Original value
                    board[r][c] = if (board[r][c] == 0) 1 else 0
                }
            }
        }
    }

    private fun liveNeighbour(board: Array<IntArray>, r: Int, c: Int): Int {
        if (r !in 0..board.lastIndex || c !in 0..board[0].lastIndex) return 0
        var count = 0
        if (c - 1 >= 0 && (board[r][c - 1] == 1 || board[r][c - 1] + 2 == 1)) count++
        if (c - 1 >= 0 && r - 1 >= 0 && (board[r - 1][c - 1] == 1 || board[r - 1][c - 1] + 2 == 1)) count++
        if (r - 1 >= 0 && (board[r - 1][c] == 1 || board[r - 1][c] + 2 == 1)) count++
        if (r - 1 >= 0 && c + 1 < board[0].size && (board[r - 1][c + 1] == 1 || board[r - 1][c + 1] + 2 == 1)) count++
        if (c + 1 < board[0].size && (board[r][c + 1] == 1 || board[r][c + 1] + 2 == 1)) count++
        if (r + 1 < board.size && c + 1 < board[0].size && (board[r + 1][c + 1] == 1 || board[r + 1][c + 1] + 2 == 1)) count++
        if (r + 1 < board.size && (board[r + 1][c] == 1 || board[r + 1][c] + 2 == 1)) count++
        if (r + 1 < board.size && c - 1 >= 0 && (board[r + 1][c - 1] == 1 || board[r + 1][c - 1] + 2 == 1)) count++
        return count
    }

}



