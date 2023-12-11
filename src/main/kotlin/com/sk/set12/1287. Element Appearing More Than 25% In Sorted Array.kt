package com.sk.set12

import java.util.*


class Solution1287 {
    fun findSpecialInteger(arr: IntArray): Int {
        val n = arr.size
        val t = n / 4

        for (i in 0 until n - t) {
            if (arr[i] == arr[i + t]) {
                return arr[i]
            }
        }
        return -1
    }

    fun findSpecialInteger2(arr: IntArray): Int {
        val n = arr.size
        if (n == 1) return arr[0]

        val list = listOf(arr[n / 4], arr[n / 2], arr[3 * n / 4])
        for (element in list) {
            val f = firstOccurrence(arr, element)
            val l = lastOccurrence(arr, element)
            if (l - f + 1 > n / 4) {
                return element
            }
        }
        return -1
    }

    private fun firstOccurrence(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1
        while (l < r) {
            val m = l + (r - l) / 2
            if (target > nums[m]) {
                l = m + 1
            } else {
                r = m
            }
        }
        return l
    }

    private fun lastOccurrence(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1
        while (l < r) {
            val m = l + (r - l + 1) / 2
            if (target >= nums[m]) {
                l = m
            } else {
                r = m - 1
            }
        }
        return l
    }
}