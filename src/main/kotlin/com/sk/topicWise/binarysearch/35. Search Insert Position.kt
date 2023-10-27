package com.sk.topicWise.binarysearch

class Solution35 {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.lastIndex
        while (l < r) {
            val m = l + (r - l) / 2
            if (target > nums[m]) {
                l = m + 1
            } else {
                r = m
            }
        }
        if (target <= nums[l]) return l
        else return l + 1
    }
}