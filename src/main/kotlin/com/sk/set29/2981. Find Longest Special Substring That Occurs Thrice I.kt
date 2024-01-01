package com.sk.set29

import java.util.PriorityQueue

class Solution2981 {
    fun maximumLength(s: String): Int {
        val map = mutableMapOf<Char, MutableList<Int>>()
        for (i in s.indices) {
            val ch = s[i]
            val list = map.getOrDefault(ch, mutableListOf<Int>())
            list.add(i)
            map[ch] = list
        }
        var ans = -1
        for (entry in map) { // total max 26
            val pq = PriorityQueue<Int>(4)
            val list = entry.value
            if (list.size < 3) continue // no 3 items
            var i = 0
            while (i < list.size) {
                val first = i
                pq.offer(1)
                if (pq.size > 3) pq.poll()
                while (i < list.size - 1 && list[i] + 1 == list[i + 1]) i++
                pq.offer(i - first + 1)
                if (pq.size > 3) pq.poll()
                i++
            }
            val segment = pq.asIterable().sorted().reversed()
            val a1 = if (segment.size >= 3) segment[2] else 0
            val a2 = if (segment.size >=2) if (segment[0] == segment[1]) segment[0]-1 else segment [1] else 0
            val a3 = segment[0] - 3 + 1
            ans = maxOf(ans, a1, a2, a3)
        }
        return ans
    }
}
