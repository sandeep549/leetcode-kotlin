package com.sk.leetcode.kotlin

private fun isAnagram(s: String, t: String): Boolean {
    val map = mutableMapOf<Char, Int>()
    for (ch in s) {
        map[ch] = map.getOrDefault(ch, 0) + 1
    }
    for (ch in t) {
        map.put(ch, map.getOrDefault(ch, 0) - 1)
        if (map[ch] == 0) map.remove(ch)
    }
    return map.isEmpty()
}

// TODO: 18/2/21 can we take this logic further?
private fun isAnagram2(s: String, t: String): Boolean {
    if (s.length != t.length) return false
    var sum = 0
    for (i in s.indices) {
        sum += s[i].toInt()
        sum -= t[i].toInt()
    }
    return sum == 0
}