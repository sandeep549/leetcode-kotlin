package com.sk.leetcode.easy

class Solution205 {

    fun isIsomorphic(s: String, t: String): Boolean {
        val m1 = IntArray(128) { -1 }
        val m2 = IntArray(128) { -1 }
        for (i in s.indices) {
            if (m1[s[i].code] != m2[t[i].code]) {
                return false
            }
            m1[s[i].code] = i
            m2[t[i].code] = i
        }
        return true
    }

    fun isIsomorphic2(s: String, t: String): Boolean {
        val map1 = mutableMapOf<Char, Char>()
        val map2 = mutableMapOf<Char, Char>()
        for (i in s.indices) {
            val a = s[i]
            val b = t[i]
            // Is a already mapped to someone?
            if (map1.containsKey(a)) {
                if (map1[a] != b) {
                    return false
                }
            } else if (map2.containsKey(b)) { // Is b already mapped to someone?
                if (map2[b] != a) {
                    return false
                }
            } else {
                map1[a] = b
                map2[b] = a
            }
        }
        return true
    }

}