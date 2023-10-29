package com.sk.topicWise.dp

class Solution198 {

    fun rob(nums: IntArray): Int {
        val dp = IntArray(nums.size) { -1 }
        tryRob(nums, nums.lastIndex, dp)
        return dp.last()
    }

    private fun tryRob(nums: IntArray, i: Int, dp: IntArray): Int {
        if (i < 0) return 0
        if (dp[i] == -1) {
            dp[i] = maxOf(tryRob(nums, i - 2, dp) + nums[i], tryRob(nums, i - 1, dp))
        }
        return dp[i]
    }

    fun rob2(nums: IntArray): Int {
        var l = 0
        var sl = 0
        for (money in nums) {
            val here = maxOf(sl + money, l)
            sl = l
            l = here
        }
        return l
    }
}

