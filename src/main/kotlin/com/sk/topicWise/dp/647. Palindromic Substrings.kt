package com.sk.topicWise.dp

class Solution647 {
    fun countSubstrings(s: String): Int {
        var ans = 0
        for (i in s.indices) {
            for (j in i until s.length) {
                var l = i
                var r = j
                var pal = true
                while (l <= r) {
                    if (s[l] != s[r]) {
                        pal = false
                        break
                    }
                    l++
                    r--
                }
                if (pal) ans++
            }
        }
        return ans
    }

    fun countSubstrings2(s: String): Int {
        var ans = 0
        fun extendPalindrome(start: Int, end: Int) {
            var l = start
            var r = end
            while (l >= 0 && r <= s.lastIndex && s[l] == s[r]) {
                ans++
                l--
                r++
            }
        }
        for (i in s.indices) {
            extendPalindrome(i, i) // odd len
            extendPalindrome(i, i + 1) // even len
        }
        return ans
    }
}
