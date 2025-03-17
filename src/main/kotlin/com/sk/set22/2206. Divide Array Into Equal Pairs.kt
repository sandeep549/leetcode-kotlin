package com.sk.set22


class Solution2206 {
    fun divideArray(nums: IntArray): Boolean {
        val frequencyMap = mutableMapOf<Int, Int>()
        for (num in nums) {
            frequencyMap[num] = frequencyMap.getOrDefault(num, 0) + 1
        }

        return frequencyMap.filter { it.value % 2 != 0 }.isEmpty()
    }
}