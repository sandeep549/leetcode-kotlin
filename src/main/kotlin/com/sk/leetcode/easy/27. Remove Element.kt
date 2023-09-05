package com.sk.leetcode.easy

class Solution27 {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var i = 0
        var j = 0
        while (j < nums.size) {
            if (nums[j] != `val`) {
                if (i != j) nums[i] = nums[j]
                i++
            }
            j++
        }
        return i
    }
}