package com.sk.set3

class Solution383 {

    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        if (ransomNote.length > magazine.length) {
            return false
        }
        val counter = IntArray(26)

        for (c in magazine.toCharArray()) {
            counter[c.code - 'a'.code]++
        }

        for (c in ransomNote.toCharArray()) {
            if (counter[c.code - 'a'.code] == 0) {
                return false
            }
            counter[c.code - 'a'.code]--
        }
        return true
    }

    fun canConstruct2(ransomNote: String, magazine: String): Boolean {
        val magazineMap = magazine.groupBy { it }.mapValues { it.value.size }.toMutableMap()
        for (ch in ransomNote) {
            if (magazineMap.containsKey(ch).not()) {
                return false
            } else {
                var v = magazineMap[ch]!! - 1
                if (v == 0) {
                    magazineMap.remove(ch)
                } else {
                    magazineMap[ch] = v
                }
            }
        }
        return true
    }
}