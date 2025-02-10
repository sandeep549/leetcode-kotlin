package com.sk.set20

class Solution2001 {
    fun interchangeableRectangles(rectangles: Array<IntArray>): Long {
        val freqMap = mutableMapOf<Double, Long>()
        var result = 0L

        for ((width, height) in rectangles) {
            val ratio = width.toDouble() / height
            result += freqMap.getOrDefault(ratio, 0)
            freqMap[ratio] = result + 1
        }

        return result
    }
}