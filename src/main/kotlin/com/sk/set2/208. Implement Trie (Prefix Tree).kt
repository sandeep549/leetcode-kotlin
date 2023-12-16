package com.sk.set2

class Trie208() {
    private val root = TrieNode()

    fun insert(word: String) {
        var n = root
        for (c in word) {
            val i = c - 'a'
            if(n.children[i] == null) n.children[i] = TrieNode()
            n = n.children[i]!!
        }
        n.wordEnd = true
    }

    fun search(word: String): Boolean {
        var n = root
        for (c in word) {
            val i = c - 'a'
            if (n.children[i] == null) return false
            n = n.children[i]!!
        }
        return n.wordEnd
    }

    fun startsWith(prefix: String): Boolean {
        var n = root
        for (c in prefix) {
            val i = c - 'a'
            if (n.children[i] == null) return false
            n = n.children[i]!!
        }
        return true // Last node has children, that means there is at least one word going through this.
    }

    private class TrieNode {
        val children = arrayOfNulls<TrieNode>(SIZE)
        var wordEnd = false
    }

    companion object {
        private const val SIZE = 25
    }
}