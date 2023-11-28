package com.sk.set0

class Solution57 {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val res = ArrayList<IntArray>()
        var newInterval = newInterval
        for (interval in intervals) {
            if (interval[1] < newInterval[0]) {         // current interval is before new one
                res.add(interval)
            } else if (newInterval[1] < interval[0]) {  // current interval is after new one
                res.add(newInterval)
                res.add(interval)
                newInterval = intArrayOf(1_00_001, 1_00_001)
            } else {                                    // Current & new interval overlap
                newInterval = intArrayOf(minOf(newInterval[0], interval[0]), maxOf(newInterval[1], interval[1]))
            }
        }
        if (newInterval[0] != 1_00_001) res.add(newInterval)
        return res.toTypedArray()
    }
}