package com.sk.set24

class Solution2429 {
    fun minimizeXor(num1: Int, num2: Int): Int {
        var result = 0
        val targetBit = num2.countOneBits()
        var setBit = 0
        var currentBit = 31 // Start from the most significant bit.

        // While the number of set bits in `result` is less than the target
        while (setBit < targetBit) {
            // If the current bit of `num1` is set or we must set all remaining bits in `result`
            if (isSet(num1, currentBit) || (targetBit - setBit > currentBit)) {
                result = setBit(result, currentBit)
                setBit++
            }
            currentBit--
        }
        return result
    }

    private fun isSet(x: Int, bit: Int): Boolean {
        return x and (1 shl bit) != 0
    }

    private fun setBit(x: Int, bit: Int): Int {
        return x or (1 shl bit)
    }
}