package com.sk.leetcode.easy

private class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var l = 0
        var r = 0
        while (r < nums.size) {
            if (nums[r] == nums[l]) {
                r++
            } else {
                l++
                nums[l] = nums[r]
                r++
            }
        }
        return l + 1
    }
}