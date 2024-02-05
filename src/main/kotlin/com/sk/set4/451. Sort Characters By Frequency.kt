package com.sk.set4

class Solution451 {
    fun frequencySort(s: String): String {
        val map = HashMap<Char, Int>()
        for(ch in s.toCharArray()) {
            map[ch] = map.getOrDefault(ch, 0) + 1
        }
        val entries = map.entries.sortedByDescending { it.value }
        val sb = StringBuilder()
        for(entry in entries) {
            repeat(entry.value) {
                sb.append(entry.key)
            }
        }
        return sb.toString()
    }
}