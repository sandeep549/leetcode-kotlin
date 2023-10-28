package com.sk.topicWise.math

class Solution66 {
    fun plusOne(digits: IntArray): IntArray {
        for (i in digits.lastIndex downTo 0) {
            if (digits[i] < 9) {
                digits[i]++
                return digits
            }
            digits[i] = 0
        }
        val ans = IntArray(digits.size + 1)
        ans[0] = 1
        return ans
    }
}
