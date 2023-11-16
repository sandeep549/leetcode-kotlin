package com.sk.easy

class Solution13 {
    fun romanToInt(s: String): Int {
        val map = mapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
        )
        var sum = 0
        for (i in 0 until s.lastIndex) {
            val curr = map[s[i]]!!
            val next = map[s[i + 1]]!!
            sum += (if (curr < next) -curr else curr)
        }
        sum += map[s[s.lastIndex]]!!
        return sum
    }
}

fun main() {
    val s = Solution13()
    println(s.romanToInt("LC"))
}