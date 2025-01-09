package com.sk.set30

class Solution3042 {
    class TrieNode {
        val children = HashMap<Int, TrieNode>()
        var count: Int = 0
    }

    fun countPrefixSuffixPairs(words: Array<String>): Long {
        val root = TrieNode()
        var res = 0L
        for (word in words) {
            var x = root
            for (i in word.indices) {
                val key = word[i].code * 128 + word[word.length - i - 1].code
                x = x.children.computeIfAbsent(key) { TrieNode() }
                res += x.count
            }
            x.count++
        }
        return res
    }
}