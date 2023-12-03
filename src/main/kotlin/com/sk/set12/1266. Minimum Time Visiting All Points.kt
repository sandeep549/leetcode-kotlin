package com.sk.set12

import kotlin.math.abs

class Solution1266 {
    fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
        var ans = 0
        for (i in 1..points.lastIndex) {
            val p1 = points[i-1]
            val p2 = points[i]
            val x = abs(p2[0] - p1[0])
            val y = abs(p2[1]-p1[1])
            if (x == 0) {
                ans += y
            } else if (y == 0) {
                ans += x
            } else {
                ans += minOf(x, y)
                ans += abs(x-y)
            }
        }
        return ans
    }

    fun minTimeToVisitAllPoints2(points: Array<IntArray>): Int {
        var ans = 0
        for (i in 1..points.lastIndex) {
            val p1 = points[i-1]
            val p2 = points[i]
            val x = abs(p2[0] - p1[0])
            val y = abs(p2[1]-p1[1])
            ans += maxOf(x, y)
        }
        return ans
    }
}