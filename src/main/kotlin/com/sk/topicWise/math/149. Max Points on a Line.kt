package com.sk.topicWise.math

import kotlin.math.atan2

/*
- Consider a point and think all other points go trough this point.
- Consider every other point slope with this point, keeping note of slope counts.
- Max slope count is max no of points through through this point.
- Update global max found so far.
- Repeat above for all the points.
 */


class Solution {
    fun maxPoints(points: Array<IntArray>): Int {
        val n = points.size
        if (n == 1) return 1
        var result = 2
        for (i in 0 until n) {
            val count: MutableMap<Double, Int> = HashMap()
            for (j in 0 until n) {
                if (i == j) continue
                val t = tan2(points[j], points[i])
                count[t] = count.getOrDefault(t, 0) + 1
            }
            result = maxOf(result, count.values.max()!! + 1)
        }
        return result
    }

    private fun tan2(p1: IntArray, p2: IntArray) =
        atan2(
            (p1[1] - p2[1]).toDouble(),
            (p1[0] - p2[0]).toDouble()
        )
}
