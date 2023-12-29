package com.sk.set21


class Solution2135 {
    fun wordCount(startWords: Array<String>, targetWords: Array<String>): Int {
        var count = 0
        for (target in targetWords) {
            val tarr = IntArray(26) { 0 }
            for (ch in target) {
                tarr[ch - 'a'] = tarr[ch - 'a'] + 1
            }
            for (start in startWords) {
                if (start.length != target.length - 1) continue
                val source = tarr.copyOf()
                for (ch in start) {
                    source[ch - 'a'] = source[ch - 'a'] - 1
                }
                if (source.filter { it == 0 }.size == 25 && source.filter { it == 1 }.size == 1) {
                    count++
                    break
                }
            }
        }
        return count
    }

    fun wordCount2(startWords: Array<String>, targetWords: Array<String>): Int {
        var ans = 0
        var m = 0
        val startSet = HashSet<Int>()
        for (w in startWords) {
            m = 0
            for (c in w.toCharArray()) {
                m = m or (1 shl c - 'a')
            }
            startSet.add(m)
        }
        for (w in targetWords) {
            m = 0
            for (c in w.toCharArray()) {
                m = m or (1 shl c - 'a')
            }
            for (c in w.toCharArray()) {
                if (startSet.contains(m - (1 shl c - 'a'))) {
                    ans++
                    break
                }
            }
        }
        return ans
    }
}