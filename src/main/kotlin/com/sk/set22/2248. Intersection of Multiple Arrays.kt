package com.sk.set22

class Solution2248 {
    fun intersection(nums: Array<IntArray>): List<Int> {
        val frequencyArr = IntArray(1000)
        nums.forEach { arr ->
            arr.forEach { item ->
                frequencyArr[item]++
            }
        }
        val intersection = mutableListOf<Int>()
        frequencyArr.forEachIndexed { index, item ->
            if (frequencyArr[item] == nums.size) {
                intersection.add(index)
            }
        }
        return intersection
    }
}