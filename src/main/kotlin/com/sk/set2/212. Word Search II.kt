package com.sk.set2


class Solution212 {
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val res = mutableListOf<String>()
        outerLoop@ for (word in words) {
            for (r in board.indices) {
                for (c in board[0].indices) {
                    val seen = Array(board.size) { BooleanArray(board[0].size) { false } }
                    if (find(word, 0, r, c, board, seen)) {
                        res.add(word)
                        continue@outerLoop
                    }
                }
            }
        }
        return res
    }

    private fun find(
        word: String, i: Int, r: Int, c: Int,
        board: Array<CharArray>, seen: Array<BooleanArray>
    ): Boolean {
        if (i == word.length) return true
        if (r < 0 || r >= board.size || c < 0 || c >= board[0].size) return false
        if (seen[r][c]) return false
        if (board[r][c] == word[i]) { // matched this character
            seen[r][c] = true
            if (find(word, i + 1, r - 1, c, board, seen) ||
                find(word, i + 1, r + 1, c, board, seen) ||
                find(word, i + 1, r, c - 1, board, seen) ||
                find(word, i + 1, r, c + 1, board, seen)
            ) return true
            seen[r][c] = false
            return false
        } else {
            return false
        }
    }
}

class Solution212_2 {
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val trie = buildTrie(words)
        val res = HashSet<String>()
        for (i in board.indices) {
            for (j in board[0].indices) {
                dfs(board, trie, res, i, j)
            }
        }
        return ArrayList(res)
    }

    private fun dfs(board: Array<CharArray>, node: Trie, res: HashSet<String>, i: Int, j: Int) {
        var node = node
        if (i < 0 || i >= board.size || j < 0 || j >= board[0].size || board[i][j] == '#' || node.next[board[i][j] - 'a'] == null) {
            return
        }
        if (node.next[board[i][j] - 'a']!!.word != null) {
            res.add(node.next[board[i][j].code - 'a'.code]!!.word!!)
        }

        // Go to next char
        node = node.next[board[i][j].code - 'a'.code]!!
        val c = board[i][j]
        board[i][j] = '#'
        dfs(board, node, res, i - 1, j)
        dfs(board, node, res, i + 1, j)
        dfs(board, node, res, i, j - 1)
        dfs(board, node, res, i, j + 1)
        board[i][j] = c
    }

    private fun buildTrie(words: Array<String>): Trie {
        val root = Trie()
        for (w in words) {
            var p = root
            for (c in w.toCharArray()) {
                if (p.next[c.code - 'a'.code] == null) {
                    p.next[c.code - 'a'.code] = Trie()
                }
                p = p.next[c.code - 'a'.code]!! // will point to curr char
            }
            p.word = w
        }
        return root
    }


    private class Trie {
        var next = arrayOfNulls<Trie>(26)
        var word: String? = null
    }

}