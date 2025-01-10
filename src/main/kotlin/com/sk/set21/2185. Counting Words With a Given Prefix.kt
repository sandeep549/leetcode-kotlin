package com.sk.set21

private class TrieNode {
    val children = mutableMapOf<Char, TrieNode>()
    var count = 0 // Tracks how many words pass through this node
}

private class Trie {
    private val root = TrieNode()

    fun insert(word: String) {
        var current = root
        for (char in word) {
            current = current.children.computeIfAbsent(char) { TrieNode() }
            current.count++
        }
    }

    fun countWordsWithPrefix(prefix: String): Int {
        var current = root
        for (char in prefix) {
            current = current.children[char] ?: return 0
        }
        return current.count
    }
}

class Solution {
    fun prefixCount(words: Array<String>, pref: String): Int {
        val trie = Trie()
        // Insert all words into the Trie
        for (word in words) {
            trie.insert(word)
        }
        // Count words with the given prefix
        return trie.countWordsWithPrefix(pref)
    }
}