package com.sk.topicWise.slidingwindow

class Solution3 {
    fun lengthOfLongestSubstring(s: String): Int {
        var l = 0
        var r = 0
        var max = 0
        val set = mutableSetOf<Char>()
        while (r < s.length) {
            if (set.contains(s[r])) {
                set.remove(s[l])
                l++
            } else {
                set.add(s[r])
                max = maxOf(max, set.size)
                r++
            }
        }
        return max
    }
}