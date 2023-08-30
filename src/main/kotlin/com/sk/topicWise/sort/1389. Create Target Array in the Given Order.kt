package com.sk.topicWise.sort

class Solution1339 {
    fun createTargetArray(nums: IntArray, index: IntArray): IntArray {
        val list = mutableListOf<Triple<Int, Int, Int>>()
        for (i in index.indices) {
            list.add(Triple(index[i], i, nums[i]))
        }
        list.sortWith(
            compareBy<Triple<Int, Int, Int>> { it.first }.thenByDescending { it.second })
        return list.map { it.third }.toIntArray()
    }
}
