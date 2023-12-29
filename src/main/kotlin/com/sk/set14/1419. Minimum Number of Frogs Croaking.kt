package com.sk.set14

class Solution1419 {
    fun minNumberOfFrogs(croakOfFrogs: String): Int {
        fun next(ch: Char) = when (ch) {
            'c' -> 'r'
            'r' -> 'o'
            'o' -> 'a'
            'a' -> 'k'
            'k' -> 'c'
            else -> 'x'
        }

        var max = 0
        val frogSet = mutableSetOf<StringBuilder>()
        outerLoop@ for (ch in croakOfFrogs) {
            for (frog in frogSet) {
                if (next(frog.last()) == ch) {
                    frog.append(ch)
                    if (frog.length == 5) {
                        frogSet.remove(frog)
                    }
                    continue@outerLoop
                }
            }
            if (ch == 'c') {
                frogSet.add(StringBuilder().append(ch))
                max = maxOf(max, frogSet.size)
            } else {
                return -1
            }
        }

        return if(frogSet.size != 0) -1 else max
    }

    fun minNumberOfFrogs2(croakOfFrogs: String): Int {
        var c = 0
        var r = 0
        var o = 0
        var a = 0
        var k = 0
        var frogs = 0 // count of simultaneous frogs
        var answer = 0
        for (d in croakOfFrogs.toCharArray()) {
            when (d) {
                'c' -> {
                    c++
                    frogs++
                }

                'r' -> r++
                'o' -> o++
                'a' -> a++
                'k' -> {
                    k++
                    frogs--
                }
            }
            answer = Math.max(answer, frogs)
            if (c < r || r < o || o < a || a < k) return -1
        }
        return if (frogs == 0 && c == r && c == o && c == a && c == k) answer else -1
    }
}