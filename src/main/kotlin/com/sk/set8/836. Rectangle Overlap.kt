package com.sk.set8

import kotlin.math.min

class Solution836 {

    // https://leetcode.com/problems/rectangle-overlap/solutions/132340/c-java-python-1-line-solution-1d-to-2d/comments/140104
    fun isRectangleOverlap(rec1: IntArray, rec2: IntArray): Boolean {
        val intersectionWidth = minOf(rec1[2], rec2[2]) - maxOf(rec1[0], rec2[0]) // on x-axis
        val intersectionHeight = minOf(rec1[3], rec2[3]) - maxOf(rec2[1], rec1[1]) // on y-axis

        return intersectionWidth > 0 && intersectionHeight > 0
    }

}