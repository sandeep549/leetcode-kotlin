package com.sk.set5


class Solution523 {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        val prefixSum = nums.runningFold(0) { sum: Int, num: Int -> sum + num }.toIntArray()
        for (i in 1 until nums.size) {
            for (j in 0 until i) {
                val s = prefixSum[i+1] - prefixSum[j]
                if (s % k == 0) return true
            }
        }
        return false
    }

    fun checkSubarraySum2(nums: IntArray, k: Int): Boolean {
        val modToIndexMap = hashMapOf<Int, Int>()
        var mod = 0
        modToIndexMap[0] = -1 // base case when subarray start with first element and mod becomes 0
        for (i in nums.indices) {
            mod = (mod + nums[i]) % k
            if (modToIndexMap.containsKey(mod)) {
                if (i - modToIndexMap[mod]!! > 1) { // ensures that the size of subarray is at least 2
                    return true
                }
            } else {
                modToIndexMap[mod] = i // mark the value of prefixMod with the current index.
            }
        }
        return false
    }
}