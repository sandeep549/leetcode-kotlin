package com.sk.set1

class Solution125 {
    fun isPalindrome(s: String): Boolean {
        var l = 0
        var r = s.lastIndex
        while (l < r) {
            while (l < r && !s[l].isLetterOrDigit()) l++
            while (l < r && !s[r].isLetterOrDigit()) r--
            if (s[l].lowercaseChar() != s[r].lowercaseChar()) {
                return false
            }
            l++
            r--
        }
        return true
    }
}