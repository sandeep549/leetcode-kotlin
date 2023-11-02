package com.sk.topicWise

class Solution228 {
    fun summaryRanges(nums: IntArray): List<String> {
        val list = mutableListOf<String>()
        if (nums.size == 0) return list
        var start = 0
        for (i in nums.indices) {
            if (i == 0) {
                start = nums[i]
            } else {
                if (nums[i] - nums[i - 1] != 1) {
                    if (start != nums[i - 1]) list.add("$start->${nums[i - 1]}")
                    else list.add("$start")
                    start = nums[i]
                }
            }
        }
        if (start != nums[nums.lastIndex]) list.add("$start->${nums[nums.lastIndex]}")
        else list.add("$start")

        return list
    }
}