package com.sk.set30

class Solution3011 {
    fun canSortArray(nums: IntArray): Boolean {
        var segmentSetBits = 0
        var currSegmentMin = 0
        var currSegmentMax = 0
        var preSegmentMax = currSegmentMax
        for (i in nums.indices) {
            val currentBits = nums[i].countOneBits()
            if (currentBits != segmentSetBits) {
                if (preSegmentMax > currSegmentMin) return false
                preSegmentMax = currSegmentMax
                segmentSetBits = nums[i].countOneBits()
                currSegmentMax = nums[i]
                currSegmentMin = nums[i]
            } else {
                currSegmentMax = maxOf(currSegmentMax, nums[i])
                currSegmentMin = minOf(currSegmentMin, nums[i])
            }
        }
        return preSegmentMax <= currSegmentMin
    }
}