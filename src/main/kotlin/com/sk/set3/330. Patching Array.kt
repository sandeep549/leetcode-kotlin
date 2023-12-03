package com.sk.set3

class Solution330 {
    fun minPatches(nums: IntArray, n: Int): Int {
        var missing: Long = 1 // Why long, for edge case when n=2147483647
        var patches = 0
        var i = 0

        while (missing <= n) {
            if (i < nums.size && nums[i] <= missing) {
                missing += nums[i]
                i++
            } else {
                missing += missing
                patches++
            }
        }

        return patches
    }
}