package com.sk.set4

class Solution409 {
    fun longestPalindrome(s: String): Int {
        val frequencyMap = s.groupBy { it }.mapValues { it.value.size }
        val odds = frequencyMap.values.filter { it % 2 != 0 }.size
        return s.length - odds + if (odds > 0) 1 else 0
    }
}