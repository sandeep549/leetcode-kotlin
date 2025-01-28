package com.sk.set29

import kotlin.math.abs


class Solution {
    fun lexicographicallySmallestArray(nums: IntArray, limit: Int): IntArray {
        // Step 1: Sort the input array to identify groups
        val numsSorted = nums.sorted()

        // Step 2: Assign each number to a group based on the `limit`
        var currGroup = 0
        val numToGroup = mutableMapOf<Int, Int>()
        val groupToList = mutableMapOf<Int, ArrayDeque<Int>>()

        for ((i, num) in numsSorted.withIndex()) {
            // Check if a new group is required
            if (i > 0 && abs(num - numsSorted[i - 1]) > limit) {
                currGroup++
            }
            // Map the number to its group
            numToGroup[num] = currGroup
            groupToList.computeIfAbsent(currGroup) { ArrayDeque() }.add(num)
        }

        // Step 3: Replace each element in the original array with the next lexicographical element from its group
        nums.forEachIndexed { i, num ->
            val group = numToGroup[num]!!
            nums[i] = groupToList[group]!!.removeFirst()
        }

        return nums
    }
}