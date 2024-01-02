package com.sk.topicWise.bitManipulation

class Solution137 {
    fun singleNumber(nums: IntArray): Int {
        var ones = 0
        var twos = 0
        for (i in nums.indices) {
            ones = ones xor nums[i] and twos.inv()
            twos = twos xor nums[i] and ones.inv()
        }
        return ones
    }
}