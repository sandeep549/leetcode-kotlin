package com.sk.set16

class Solution1637 {
    fun maxWidthOfVerticalArea(points: Array<IntArray>): Int {
        points.sortBy { it[0] }
        var max = 0
        for (i in 1..points.lastIndex) {
            if (points[i][0] - points[i-1][0] > max) max = points[i][0] - points[i-1][0]
        }
        return max
    }
}