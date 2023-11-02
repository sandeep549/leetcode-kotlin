package com.sk.topicWise

class Solution242 {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }
        val count = IntArray(26)
        for (i in s.indices) {
            count[s[i].code - 'a'.code]++
            count[t[i].code - 'a'.code]--
        }
        return count.none { it != 0 }
    }
}