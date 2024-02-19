package com.sk.set24

import java.util.*

class Solution2402 {
    fun mostBooked(n: Int, meetings: Array<IntArray>): Int {
        val cnt = IntArray(101)
        meetings.sortWith(compareBy({ it[0] }, { it[1] }))
        val avail = PriorityQueue<Int>(compareBy { it }) // <Room No>
        val busy = PriorityQueue<Pair<Long, Int>>(compareBy { it.first }) // <End Time, Room No>

        for (i in 0 until n)
            avail.add(i)

        for (m in meetings) {
            while (busy.isNotEmpty() && busy.peek().first <= m[0]) {
                avail.add(busy.poll().second)
            }
            val start = if (avail.isEmpty()) busy.peek().first else m[0].toLong()
            val duration = m[1] - m[0]
            val room = if (avail.isEmpty()) busy.poll().second else avail.poll()
            cnt[room]++
            busy.add(Pair(start + duration, room))
        }
        return cnt.indices.maxByOrNull { cnt[it] } ?: -1
    }
}