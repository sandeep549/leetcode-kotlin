package com.sk.set21

import java.util.PriorityQueue

class Solution2182 {
    fun repeatLimitedString(s: String, repeatLimit: Int): String {
        val map = s.groupBy { it }.mapValues { it.value.size }
        val pq = PriorityQueue<Pair<Char, Int>>() { a, b -> b.first - a.first }
        for (entry in map) {
            pq.offer(Pair(entry.key, entry.value))
        }
        val sb = StringBuilder()
        while (pq.isNotEmpty()) {
            val top = pq.poll()
            if (top.second <= repeatLimit) {
                repeat(top.second) { sb.append(top.first) }
            } else {
                repeat(repeatLimit) { sb.append(top.first) }
                if (pq.size == 0) break
                val second = pq.poll()
                sb.append(second.first)
                pq.offer(Pair(top.first, top.second - repeatLimit))
                if (second.second > 1) pq.offer(Pair(second.first, second.second - 1))
            }
        }
        return sb.toString()
    }
}