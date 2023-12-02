package com.sk.set11

class Solution1160 {
    fun countCharacters(words: Array<String>, chars: String): Int {
        val map = HashMap<Char, Int>()
        for (ch in chars) {
            map[ch] = map.getOrDefault(ch, 0) + 1
        }

        var res = 0
        for (word in words) {
            val m = map.toMutableMap()
            var add = true
            for (ch in word.toCharArray()) {
                m[ch] = m.getOrDefault(ch, 0) - 1
                if (m[ch]!! < 0) {
                    add = false
                    break
                };
            }
            if (add) res += word.length
        }

        return res
    }
}