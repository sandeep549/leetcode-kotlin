package com.sk.topicWise.hashtable

import kotlin.math.min

private fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val map1 = nums1.toList().groupingBy { it }.eachCount()
    val map2 = nums2.toList().groupingBy { it }.eachCount()
    val ans = ArrayList<Int>()
    map1.forEach { (k, v) ->
        if (map2.containsKey(k)) {
            for (i in 1..min(v, map2[k]!!)) ans.add(k)
        }
    }
    return ans.toIntArray()
}

private fun intersect2(nums1: IntArray, nums2: IntArray): IntArray {
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
