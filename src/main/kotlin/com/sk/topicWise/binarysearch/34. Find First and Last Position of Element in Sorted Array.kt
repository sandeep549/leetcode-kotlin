package com.sk.topicWise.binarysearch


class Solution34 {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        var l = 0
        var r = nums.lastIndex
        while (l < r) { // find first on left side, always keep left element in search space
            val mid = l + (r - l) / 2
            if (nums[mid] < target) {
                l = mid + 1
            } else {
                r = mid
            }
        }
        val first = l
        // don't reset lo to 0
        r = nums.lastIndex
        while (l < r) { // // find first on left side, always keep left element in search space
            val mid = l + (r - l + 1) / 2 // keep mid towards hi side
            if (nums[mid] <= target) {
                l = mid
            } else {
                r = mid - 1
            }
        }
        return if (nums.isEmpty() || nums[l] != target) {
            intArrayOf(-1, -1)
        } else {
            intArrayOf(first, l)
        }
    }
}
