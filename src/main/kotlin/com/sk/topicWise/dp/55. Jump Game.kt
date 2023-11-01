package com.sk.topicWise.dp

class Solution55 {
    fun canJump(nums: IntArray): Boolean {
        if (nums.size <= 1) return true
        val dp = BooleanArray(nums.size)
        return jump(nums, nums.lastIndex, dp)
    }

    fun jump(nums: IntArray, n: Int, dp: BooleanArray): Boolean {
        if (dp[n] || n == 0) return true
        for (i in 0 until n) {
            if (i + nums[i] >= n && jump(nums, i, dp)) {
                dp[n] = true
            }
        }
        return dp[n]
    }

    fun canJump2(nums: IntArray): Boolean {
        if (nums.size <= 1) return true
        val dp = BooleanArray(nums.size)
        dp[0] = true
        for (i in 0 until nums.lastIndex) {
            if (!dp[i]) continue
            for (k in 1..nums[i]) {
                dp[i + k] = true
                if (i + k == nums.lastIndex) break
            }
        }
        return dp.last()
    }

    fun canJump3(nums: IntArray): Boolean {
        var lastPos: Int = nums.lastIndex
        for (i in nums.lastIndex downTo 0) {
            if (i + nums[i] >= lastPos) {
                lastPos = i
            }
        }
        return lastPos == 0
    }
}


