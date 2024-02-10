package com.sk.topicWise.dp.medium

class Solution368 {
    fun largestDivisibleSubset(nums: IntArray): List<Int> {
        nums.sort()
        val count = IntArray(nums.size)
        val pre = IntArray(nums.size)
        var maxIndex = -1
        for(i in nums.indices) {
            count[i] = 1
            pre[i] = -1
            for (j in i-1 downTo 0) {
                if (nums[i] % nums[j] == 0) {
                    if(count[j] + 1 > count[i]) { // local max ending with i
                        count[i] = count[j] + 1
                        pre[i] = j
                    }
                }
            }
            // global max
            if (maxIndex == -1 || count[i] > count[maxIndex]) {
                maxIndex = i
            }
        }

        val result = mutableListOf<Int>()
        while (maxIndex != -1) {
            result.add(nums[maxIndex])
            maxIndex = pre[maxIndex]
        }

        return result
    }
}