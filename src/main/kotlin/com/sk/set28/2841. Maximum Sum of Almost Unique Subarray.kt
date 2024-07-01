package com.sk.set28

class Solution2841 {
    fun maxSum(nums: List<Int>, m: Int, k: Int): Long {
        val freqMap = mutableMapOf<Int, Int>()
        var currentSum = 0L
        var maxSum = 0L
        var l = 0
        var r = 0
        while (r < nums.size) {
            if (r - l < k) {
                freqMap[nums[r]] = freqMap.getOrDefault(nums[r], 0) + 1
                currentSum += nums[r]
                r++
            } else {
                freqMap[nums[r]] = freqMap.getOrDefault(nums[r], 0) + 1
                freqMap[nums[l]] = freqMap.getOrDefault(nums[l], 0) - 1
                currentSum += nums[r]
                currentSum -= nums[l]
                if (freqMap[nums[l]]!! == 0) freqMap.remove(nums[l])
                r++
                l++
            }
            if (freqMap.size >= m) {
                maxSum = maxOf(maxSum, currentSum)
            }
        }
        return maxSum
    }
}