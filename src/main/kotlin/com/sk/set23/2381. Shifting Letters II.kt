package com.sk.set23

class Solution2381 {
    fun shiftingLetters(s: String, shifts: Array<IntArray>): String {
        val n = s.length
        val finalShift = IntArray(n) // Extra space to handle range updates

        // Apply the range updates
        for ((l, r, direction) in shifts) {
            val shiftValue = if (direction == 1) 1 else -1
            finalShift[l] += shiftValue
            if (r + 1 < n) {
                finalShift[r + 1] -= shiftValue
            }
        }

        // Compute the prefix sum to get the final shifts for each character
        for (i in 1 until n) {
            finalShift[i] += finalShift[i - 1]
        }

        // Build the shifted string
        val result = StringBuilder()
        for (i in s.indices) {
            val shift = (finalShift[i] % 26 + 26) % 26 // Ensure the shift is positive
            val newChar = 'a' + (s[i] - 'a' + shift) % 26
            result.append(newChar)
        }

        return result.toString()
    }
}