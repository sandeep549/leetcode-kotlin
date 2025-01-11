package com.sk.set14

class Solution1400 {
    fun canConstruct(s: String, k: Int): Boolean {
        if (s.length < k) return false

        // Step 1: Create a bitmask for character frequencies
        var mask = 0
        for (char in s) {
            mask = mask xor (1 shl (char - 'a'))
        }

        // Step 2: Count the number of set bits (odd frequencies)
        val oddCount = mask.countOneBits()

        // Step 3: Check if the odd frequencies are <= k
        return oddCount <= k
    }
}