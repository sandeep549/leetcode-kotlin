package com.sk.leetcode.easy

class Solution1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for(i in nums.indices) {
            if(map.contains(target - nums[i])) {
                return intArrayOf(map[target-nums[i]]!!, i)
            } else {
                map[nums[i]] = i
            }
        }
        return intArrayOf(-1, -1)
    }
}