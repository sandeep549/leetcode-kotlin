package com.sk.topicWise.binarysearch

class Solution1011 {
    fun shipWithinDays(weights: IntArray, days: Int): Int {
        var l = weights.max()
        var r = weights.sum()
        while (l < r) {
            val m = l + (r - l) / 2
            val d = findDays(m, weights)
            if (d > days) {
                l = m + 1
            } else {
                r = m
            }
        }
        return l
    }

    fun findDays(allowed: Int, weights: IntArray): Int {
        var w = 0
        var days = 0
        for (item in weights) {
            if (w + item > allowed) {
                days++
                w = 0
            }
            w += item
        }
        return days + 1 // for last weight
    }
}
