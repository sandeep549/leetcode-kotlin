package com.sk.set7

class Solution724 {
    fun pivotIndex(nums: IntArray): Int {
        var leftSum = 0
        var rightSum = nums.sum()
        for(i in nums.indices) {
            leftSum += nums.getOrElse(i-1) { 0 }
            rightSum -= nums[i]
            if(leftSum < rightSum) return i
        }
        return -1
    }
}