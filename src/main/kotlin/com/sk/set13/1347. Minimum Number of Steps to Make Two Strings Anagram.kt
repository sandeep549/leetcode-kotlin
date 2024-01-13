package com.sk.set13

class Solution1347 {
    fun minSteps(s: String, t: String): Int {
        val arr = IntArray(26)
        for (i in s.indices) {
            arr[s[i] - 'a']++
            arr[t[i] - 'a']--
        }
        return arr.filter { it > 0 }.sum()
    }
}