package com.sk.set19

class Solution1904 {
    fun numberOfRounds(s: String, f: String): Int {
        val start = 60 * s.substring(0, 2).toInt() + s.substring(3).toInt()
        var finish = 60 * f.substring(0, 2).toInt() + f.substring(3).toInt()
        if (start > finish) finish += (60 * 24)
        return maxOf(0, finish / 15 - (start + 14) / 15) // max(0, floor(finish / 15) - ceil(start / 15))
    }
}