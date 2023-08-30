package com.sk.leetcode.kotlin

private fun findLongestWord(s: String, d: List<String>): String {
    var longest = ""
    for (word in d) {
        var i = 0 // index in s
        var j = 0 // index in word
        while (i < s.length) {
            if (j < word.length && word[j] == s[i]) j++
            i++
        }
        if (j == word.length) {
            if (longest.length == word.length && word < longest) longest = word
            if (longest.length < word.length) longest = word
        }
    }
    return longest
}
