package com.sk.set32

class Solution3254 {
    fun resultsArray(nums: IntArray, k: Int): IntArray {
        val powerList = mutableListOf<Int>()
        var l = 0
        var r = l+k-1
        while (r <= nums.lastIndex) {
            var max = nums[l]
            var consecutive = true
            for (i in l..r) {
                max= maxOf(max, nums[i])
                if (k > 1 && i > 0 && nums[i] - 1 != nums[i-1]) {
                    consecutive = false
                    break
                }
            }
            powerList.add(if (consecutive) max else -1)
            l++
            r++
        }
        return powerList.toIntArray()
    }
}