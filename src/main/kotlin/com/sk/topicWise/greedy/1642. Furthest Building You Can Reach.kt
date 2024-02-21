package com.sk.topicWise.greedy

import java.util.*


class Solution1642 {
    fun furthestBuilding(heights: IntArray, bricks: Int, ladders: Int): Int {
        var bricks = bricks
        var ladders = ladders
        val pq = PriorityQueue(Collections.reverseOrder<Int>())
        for (i in 0 until heights.size - 1) {
            if (heights[i + 1] <= heights[i]) continue
            bricks -= heights[i + 1] - heights[i]
            pq.add(heights[i + 1] - heights[i])
            if (bricks < 0) {
                bricks += pq.poll()
                if (ladders > 0) {
                    ladders--
                } else {
                    return i
                }
            }
        }
        return heights.size - 1
    }
}

class Solution {
    fun countPrefixSuffixPairs(words: Array<String>): Int {
        var ans = 0
        for(i in 0 until words.size-2) {
            for(j in 1 until words.size-1) {
                if(words[j].startsWith(words[i]) && words[j].endsWith(words[i]) && words[i] != words[j]) ans++
            }
        }
        return ans
    }
}