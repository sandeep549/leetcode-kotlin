package com.sk.set3

class Solution350 {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val freqMap = nums1.groupBy { it }.mapValues { it.value.size }.toMutableMap()
        val intersection = mutableListOf<Int>()
        nums2.forEach { item ->
            if (freqMap.getOrDefault(item, 0) > 0) {
                intersection.add(item)
                freqMap[item] = freqMap[item]!! - 1
            }
        }
        return intersection.toIntArray()
    }

    fun intersect2(nums1: IntArray, nums2: IntArray): IntArray {
        nums1.sort()
        nums2.sort()
        var i = 0
        var j = 0
        val ans = mutableListOf<Int>()
        while (i < nums1.size && j < nums2.size) {
            when {
                nums1[i] < nums2[j] -> i++
                nums1[i] > nums2[j] -> j++
                else -> {
                    ans.add(nums1[i])
                    i++
                    j++
                }
            }
        }
        return ans.toIntArray()
    }
}
