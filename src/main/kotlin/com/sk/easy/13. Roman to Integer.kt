package com.sk.easy

class Solution13 {
    fun romanToInt(romanString: String): Int {
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
        for (i in 0 until romanString.lastIndex) {
            val curr = map[romanString[i]]!!
            val next = map[romanString[i + 1]]!!
            sum += (if (curr < next) -curr else next)
        }
        sum += map[romanString[romanString.lastIndex]]!!
        return sum
    }
}