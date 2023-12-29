package com.sk.set22

class Solution2294 {
    fun partitionArray(nums: IntArray, k: Int): Int {
        nums.sort()
        var i = 0
        var count = 0
        while(i < nums.size) {
            val target = nums[i] + k
            while (i < nums.size && nums[i] <= target) {
                i++
            }
            count++
        }
        return count
    }
}