package com.sk.leetcode.easy

class Solution219 {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            if (map.containsKey(nums[i])) {
                val index = map[nums[i]]!!
                if (i - index <= k) return true
            }
            map[nums[i]] = i
        }
        return false
    }
}