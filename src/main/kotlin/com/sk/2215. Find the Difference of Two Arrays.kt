package com.sk

class Solution2215 {
    fun findDifference1(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        val set1 = nums1.toSet()
        val set2 = nums2.toSet()
        val ans1 = mutableSetOf<Int>()
        val ans2 = mutableSetOf<Int>()
        for (item in nums1) if (set2.contains(item).not()) ans1.add(item)
        for (item in nums2) if (set1.contains(item).not()) ans2.add(item)
        return listOf(ans1.toList(), ans2.toList())
    }

    fun findDifference2(nums1: IntArray, nums2: IntArray): List<List<Int>> {
        val set1 = nums1.toSet()
        val set2 = nums2.toSet()
        return listOf((set1-set2).toList(), (set2-set1).toList())
    }
}