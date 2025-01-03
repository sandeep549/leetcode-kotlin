package com.sk.set22

class Solution2270 {
    fun waysToSplitArray(nums: IntArray): Int {
        var leftSum = 0L
        var rightSum = nums.sumOf { it.toLong() }
        var ways = 0
        for (i in 0 until nums.lastIndex) {
            leftSum += nums[i]
            rightSum -= nums[i]
            ways += if (leftSum >= rightSum) 1 else 0
        }
        return ways
    }
}