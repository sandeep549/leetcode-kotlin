package com.sk.topicWise.binarysearch

class Solution153 {
    fun findMin(nums: IntArray): Int {
        var l = 0
        var r = nums.lastIndex
        if (nums[l] < nums[r]) return nums[l] // if 0 rotation
        while (l < r - 1) { // keep 2 element in search space smallest and biggest
            val m = l + (r - l) / 2
            if (nums[m] > nums[l]) {
                l = m
            } else {
                r = m
            }
        }
        return nums[r]
    }

    fun findMin2(nums: IntArray): Int {
        var l = 0
        var r = nums.lastIndex
        while (l < r) {
            val mid = l + (r - l) / 2
            if (nums[mid] > nums[r]) { // Why comparing with right element and not left ?
                l = mid + 1
            } else {
                r = mid
            }
        }
        return nums[l]
    }

//    fun findMin3(nums: IntArray): Int {
//        var l = 0
//        var r = nums.lastIndex
//        // Find max, and next will be smallest
//        while (l < r) {
//            val mid = l + (r - l) / 2
//            if (nums[mid] < nums[l]) { // Why comparing with left element and not right ?
//                l = mid + 1
//            } else {
//                r = mid
//            }
//        }
//        return nums[l+1/nums.size] // next will be smallest
//    }
}