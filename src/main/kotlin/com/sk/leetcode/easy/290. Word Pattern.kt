package com.sk.leetcode.easy

class Solution290 {
    fun wordPattern(pattern: String, s: String): Boolean {
        val words = s.split(" ")
        val map1 = mutableMapOf<Char, Int>()
        val map2 = mutableMapOf<String, Int>()
        for (i in pattern.indices) {
            if (map1[pattern[i]] != map2[words[i]]) {
                return false
            }
            map1[pattern[i]] = i
            map2[words[i]] = i
        }
        return true
    }
}