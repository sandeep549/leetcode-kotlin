package com.sk.leetcode.kotlin

import java.util.TreeMap

private class TweetCounts {
    var map = mutableMapOf<String, TreeMap<Int, Int>>()
    fun recordTweet(tweetName: String, time: Int) {
        map.putIfAbsent(tweetName, TreeMap())
        val tm = map[tweetName]
        tm!![time] = tm.getOrDefault(time, 0) + 1
    }

    fun getTweetCountsPerFrequency(
        freq: String,
        tweetName: String?,
        startTime: Int,
        endTime: Int
    ): List<Int> {
        val res = mutableListOf<Int>()
        if (!map.containsKey(tweetName)) return res
        val tm = map[tweetName]
        var gap = 60
        if (freq == "hour") gap = 3600 else if (freq == "day") gap = 3600 * 24
        var start = startTime
        while (start < endTime + 1) {
            var sum = 0
            val end = minOf(start + gap, endTime + 1)
            val sm: Map<Int, Int> = tm!!.subMap(start, end)
            for (value in sm.values) sum += value
            res.add(sum)
            start += gap
        }
        return res
    }
}