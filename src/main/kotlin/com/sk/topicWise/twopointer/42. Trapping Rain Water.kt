package com.sk.topicWise.twopointer

class Solution42 {
    fun trap2(height: IntArray): Int {
        if (height.size <= 2) return 0
        val L = IntArray(height.size)
        val R = IntArray(height.size)
        for (i in 1 until height.size) {
            L[i] = maxOf(height[i - 1], L[i - 1])
        }
        for (i in height.size - 2 downTo 0) {
            R[i] = maxOf(height[i + 1], R[i + 1])
        }
        var res = 0
        for (i in height.indices) {
            val max = minOf(L[i], R[i])
            val here = max - height[i]
            if (here <= 0) continue
            res += here
        }
        return res
    }

    fun trap(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var leftmax = 0
        var rightmax = 0
        var res = 0
        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] > leftmax) leftmax = height[left]
                else res += (leftmax - height[left])
                left++
            } else {
                if (height[right] > rightmax) rightmax = height[right]
                else res += (rightmax - height[right])
                right--
            }
        }
        return res
    }
}
