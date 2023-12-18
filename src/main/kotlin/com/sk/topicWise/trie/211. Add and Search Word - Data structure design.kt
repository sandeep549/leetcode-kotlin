package com.sk.topicWise.trie

class WordDictionary() {

    private class TrieNode {
        var wordEnd = false
        var children = HashMap<Char, TrieNode>()
    }

    private var root = TrieNode()

    fun addWord(word: String) {
        var cur = root
        for (ch in word) {
            if (!cur.children.containsKey(ch)) cur.children[ch] = TrieNode()
            cur = cur.children[ch]!!
        }
        cur.wordEnd = true
    }

    fun search(word: String): Boolean {
        return search(word, 0, root)
    }

    private fun search(word: String, k: Int, trieNode: TrieNode): Boolean {
        var cur = trieNode
        for (i in k..word.lastIndex) {
            val ch = word[i]
            if (ch == '.') {
                for (node in cur.children.values) {
                    if (search(word, i + 1, node)) return true
                }
                return false
            }

            if (!cur.children.containsKey(ch)) return false

            cur = cur.children[ch]!!
        }
        return cur.wordEnd
    }
}

//######################################################################
//
//######################################################################
class WordDictionary211_2() {
    private val root = TrieNode()

    fun addWord(word: String) {
        var cur = root
        for (ch in word) {
            val idx = ch - 'a'
            if (cur.children[idx] == null) cur.children[idx] = TrieNode()
            cur = cur.children[idx]!!
        }
        cur.wordEnd = true
    }

    fun search(word: String): Boolean {
        return find(word, 0, root)
    }

    private fun find(word: String, k: Int, node: TrieNode): Boolean {
        var cur = node
        for (i in k..word.lastIndex) {
            val ch = word[i]
            if (ch == '.') {
                for (n in cur.children) {
                    if (n == null) continue
                    if (find(word, i + 1, n)) return true
                }
                return false
            }
            val idx = ch - 'a'
            if (cur.children[idx] == null) return false
            cur = cur.children[idx]!!
        }
        return cur.wordEnd
    }

    private class TrieNode {
        val children = arrayOfNulls<TrieNode>(26)
        var wordEnd = false
    }

}


