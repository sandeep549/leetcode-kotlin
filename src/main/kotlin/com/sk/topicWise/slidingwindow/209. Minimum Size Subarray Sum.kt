package com.sk.topicWise.slidingwindow

class Solution209 {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var min = nums.size + 1
        var l = 0
        var r = 0
        var sum = 0
        while (r < nums.size) {
            sum += nums[r]
            r++
            while (sum >= target) {
                min = minOf(min, r - l)
                sum -= nums[l]
                l++
            }
        }
        return if (min > nums.size) 0 else min
    }
}