package com.sk.set26

class Solution2682 {
    fun circularGameLosers(n: Int, k: Int): IntArray {
        val res = IntArray(n) { it + 1 }
        var pos = 0
        var mul = 1
        while (res[pos] != 0) {
            res[pos] = 0
            pos = (pos + mul * k) % n
            mul++
        }
        return res.filter { it != 0 }.toIntArray()
    }
}