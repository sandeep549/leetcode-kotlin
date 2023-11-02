package com.sk.topicWise

import kotlin.math.abs

class Solution977 {
    fun sortedSquares(nums: IntArray): IntArray {
        val ret = IntArray(nums.size)
        var l = 0
        var r = nums.size - 1
        var i = nums.size - 1
        while (l <= r) {
            if (abs(nums[l]) > abs(nums[r])) {
                ret[i] = nums[l] * nums[l]
                l++
            } else {
                ret[i] = nums[r] * nums[r]
                r--
            }
            i--
        }
        return ret
    }
}