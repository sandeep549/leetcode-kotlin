package com.sk.topicWise.bitManipulation

class Solution136 {
    fun findNumber(nums: IntArray): Int {
        var ans = 0
        for (n in nums) {
            ans = ans xor n
        }
        return ans
    }
}