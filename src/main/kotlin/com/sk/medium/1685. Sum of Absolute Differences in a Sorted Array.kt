package com.sk.medium

class Solution1685 {
    /**
     * res[i] = (nums[i] - nums[0]) + (nums[i] - nums[1]) + ... + (nums[i] - nums[i - 1])        <--- absolute difference of nums[i] with first i numbers
     *      + (nums[i] - nums[i]) + (nums[i + 1] - nums[i]) + (nums[i + 2] - nums[i]) + ... + (nums[n - 1] - nums[i])   <--- absolute difference of nums[i] with last n - i numbers
     *
     * after simplification:
     *
     * res[i] = i * nums[i] - (nums[0] + ... + nums[i - 1])        <--- absolute difference of nums[i] with first i numbers
     *      + (nums[i + 1] + ... + nums[n]) - (n - i) * nums[i]   <--- absolute difference of nums[i] with last n - i numbers
     *
     *after simplification:
     *
     * res[i] = i * nums[i] - prefixSum[i]
     *      + prefixSum[n] - prefixSum[i] - (n - i) * nums[i]
     */
    fun getSumAbsoluteDifferences(nums: IntArray): IntArray {
        val n = nums.size
        val prefixSum = IntArray(n + 1)
        for (i in 0 until n) {
            prefixSum[i + 1] = prefixSum[i] + nums[i]
        }

        val res = IntArray(n)
        for (i in 0 until n) {
            res[i] = i * nums[i] - prefixSum[i] + (prefixSum[n] - prefixSum[i] - (n - i) * nums[i])
        }
        return res
    }


    fun getSumAbsoluteDifferences2(nums: IntArray): IntArray {
        val n = nums.size
        var leftSum = 0
        var rightSum = nums.sum()
        val res = IntArray(n)
        for (i in 0 until n) {
            res[i] = i * nums[i] - leftSum + rightSum - (n - i) * nums[i]
            leftSum += nums[i]
            rightSum -= nums[i]
        }
        return res
    }
}