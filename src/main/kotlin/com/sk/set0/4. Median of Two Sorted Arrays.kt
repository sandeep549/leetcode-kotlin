package com.sk.set0

class Solution4 {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val m = nums1.size
        val n = nums2.size
        val mid = (m + n) / 2
        var count = 1
        var v1 = 0
        var v2 = 0
        var i = 0
        var j = 0
        while (count <= mid + 1) {
            if ((j >= nums2.size) || (i < nums1.size && nums1[i] <= nums2[j])) {
                v2 = v1
                v1 = nums1[i]
                i++
            } else {
                v2 = v1
                v1 = nums2[j]
                j++
            }
            count++
        }

        return if ((m + n) % 2 != 0) {
            v1.toDouble()
        } else {
            (v1 + v2) / 2.toDouble()
        }
    }
}