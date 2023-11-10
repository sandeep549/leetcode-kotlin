package com.sk.topicWise.binarysearch

class Solution162 {
    fun findPeakElement(arr: IntArray): Int {
        var l = 0
        var r = arr.lastIndex
        while (l < r) {
            val m = l + (r - l) / 2
            if (arr[m] < arr[m + 1]) l = m + 1
            else r = m
        }
        return l
    }

    fun findPeakElement2(nums: IntArray): Int {
        for (i in 0 until nums.lastIndex) {
            if (nums[i] > nums[i + 1]) return i
        }
        return nums.lastIndex
    }

}

