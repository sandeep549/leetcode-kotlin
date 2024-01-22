package com.sk.topicWise.greedy

class Solution435 {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        var end = Int.MIN_VALUE
        var cnt = 0
        for ((s, e) in intervals.sortedBy { it[1] }) { // Learning
            if (s >= end) {
                end = e
            } else {
                cnt++
            }
        }
        return cnt
    }
}
