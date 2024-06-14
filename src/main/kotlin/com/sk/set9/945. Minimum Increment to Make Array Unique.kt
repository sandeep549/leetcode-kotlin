package com.sk.set9

import kotlin.math.max


class Solution945 {
    fun minIncrementForUnique(nums: IntArray): Int {
        nums.sort()
        var minIncrements = 0
        for (i in 1 until nums.size) {
            if (nums[i] <= nums[i - 1]) {
                val increment = nums[i - 1] + 1 - nums[i]
                minIncrements += increment
                nums[i] = nums[i - 1] + 1
            }
        }
        return minIncrements
    }

    fun minIncrementForUnique2(nums: IntArray): Int {
        val frequencyCount = IntArray(nums.max() + nums.size)
        for (`val` in nums) {
            frequencyCount[`val`]++
        }

        var minIncrements = 0
        for (i in frequencyCount.indices) {
            if (frequencyCount[i] <= 1) continue
            val duplicates = frequencyCount[i] - 1
            frequencyCount[i + 1] += duplicates
            minIncrements += duplicates
        }
        return minIncrements
    }
}