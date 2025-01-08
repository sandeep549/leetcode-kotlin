package com.sk.set30

class Solution3042 {
    class TrieNode {
        val children: HashMap<Int, TrieNode> = HashMap()
        var count: Int = 0
    }

    fun countPrefixSuffixPairs(words: Array<String>): Int {
        val root = TrieNode()
        var res = 0
        for (word in words) {
            var x = root
            for (i in 0 until word.length) {
                val key = word[i].toInt() * 128 + word[word.length - i - 1].toInt()
                x = x.children.computeIfAbsent(key) { TrieNode() }
                res += x.count
            }
            x.count++
        }
        return res
    }
}