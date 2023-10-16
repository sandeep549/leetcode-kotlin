package com.sk.leetcode.easy

class Solution392 {

    fun isSubsequence(s: String, t: String): Boolean {
        var si = 0
        var ti = 0
        while (ti < t.length) {
            if (s[si] == t[ti]) {
                si++
                if (si == s.length) {
                    return true
                }
            }
            ti++
        }
        return false
    }

    fun isSubsequence3(s: String, t: String): Boolean {
        // pre-process t
        val map = mutableMapOf<Char, MutableList<Int>>()
        for (i in t.indices) {
            if (map[t[i]].isNullOrEmpty()) {
                map[t[i]] = mutableListOf()
            }
            map[t[i]]?.add(i)
        }

        var lastIndex = -1
        for (i in s.indices) {
            if (map[s[i]].isNullOrEmpty()) {
                return false
            } else {
                val list = map[s[i]]
                val index = list!!.binarySearch(lastIndex + 1, 0, list.size)
                if (-(index + 1) >= list.size) {
                    return false
                }
                lastIndex = if (index < 0) list[-(index + 1)] else list[index]
            }
        }

        return true
    }

    fun isSubsequence2(s: String, t: String): Boolean {
        var i = 0
        var j = 0
        while (i < s.length) {
            while (j < t.length) {
                if (s[i] == t[j]) {
                    i++
                    j++
                    break
                }
                j++
            }
            if (i < s.length && j == t.length) {
                return false
            }
        }
        return true
    }
}