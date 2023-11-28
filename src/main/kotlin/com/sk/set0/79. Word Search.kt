package com.sk.set0

private fun exist(board: Array<CharArray>, word: String): Boolean {
    val seen = Array(board.size) { BooleanArray(board[0].size) { false } }
    fun find(cr: Int, cc: Int, i: Int): Boolean {
        if (i == word.length) return true
        if (cr >= board.size || cr < 0 || cc >= board[0].size || cc < 0 ||
            seen[cr][cc] || board[cr][cc] != word[i]
        ) {
            return false
        }

        seen[cr][cc] = true
        val left = find(cr, cc - 1, i + 1)
        val right = find(cr, cc + 1, i + 1)
        val up = find(cr - 1, cc, i + 1)
        val down = find(cr + 1, cc, i + 1)
        seen[cr][cc] = false
        return left || right || up || down
    }
    for (r in board.indices) {
        for (c in board[0].indices) {
            if (find(r, c, 0)) return true
        }
    }
    return false
}

private fun exist2(board: Array<CharArray>, word: String): Boolean {
    val seen = Array(board.size) { BooleanArray(board[0].size) { false } }
    fun find(cr: Int, cc: Int, i: Int): Boolean {
        if (i == word.length) return true
        if (cr >= board.size || cr < 0 || cc >= board[0].size || cc < 0 ||
            seen[cr][cc] || board[cr][cc] != word[i]
        ) {
            return false
        }

        board[cr][cc] = '*' // mark visited
        val left = find(cr, cc - 1, i + 1)
        val right = find(cr, cc + 1, i + 1)
        val up = find(cr - 1, cc, i + 1)
        val down = find(cr + 1, cc, i + 1)
        board[cr][cc] = word[i] // re-write original char back
        return left || right || up || down
    }
    for (r in board.indices) {
        for (c in board[0].indices) {
            if (find(r, c, 0)) return true
        }
    }
    return false
}

