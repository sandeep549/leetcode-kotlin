package com.sk

class Solution11 {
    fun maxArea(height: IntArray): Int {
        var max = 0
        var l = 0
        var r = height.lastIndex
        while (l < r) {
            val curr = (r - l) * minOf(height[l], height[r])
            max = maxOf(max, curr)
            if (height[l] <= height[r]) l++
            else r--
        }
        return max
    }
}