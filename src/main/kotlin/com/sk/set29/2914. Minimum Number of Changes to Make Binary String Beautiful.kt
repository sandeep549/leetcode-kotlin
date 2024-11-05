package com.sk.set29

class Solution2914 {
    fun minChanges(s: String): Int {
        var changes = 0
        var i = 0
        while (i + 1 < s.length) {
            if (s[i] != s[i + 1]) {
                changes += 1
            }
            i += 2
        }
        return changes
    }
}