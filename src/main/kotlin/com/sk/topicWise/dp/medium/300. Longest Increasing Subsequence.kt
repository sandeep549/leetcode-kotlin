package com.sk.topicWise.dp.medium

import kotlin.math.max

/**
 * LIS ending at index i, including index i
 * L(i) = max(L(j)) + 1, where 0<=j<i and arr[j] <= arr[i]
 */

class Solution300 {
    fun lengthOfLIS(nums: IntArray): Int {
        val dp = IntArray(nums.size) { 1 }
        for (i in nums.indices) {
            for (j in 0 until i) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1
                }
            }
        }
        return dp.max()
    }

    fun lengthOfLIS2(nums: IntArray): Int {
        val sub = mutableListOf<Int>()
        for (x in nums) {
            if (sub.isEmpty() || sub.last() < x) {
                sub.add(x)
            } else {
                val index = sub.binarySearch(x).let { if (it < 0) -it - 1 else it }
                sub[index] = x
            }
        }
        return sub.size
    }

}

