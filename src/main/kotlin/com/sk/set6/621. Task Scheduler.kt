package com.sk.set6

import com.sk.topicWise.linkedlist.ListNode
import java.util.*
import java.util.function.Consumer


class Solution621 {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        // Build frequency map
        val freq = IntArray(26)
        for (ch in tasks) {
            freq[ch - 'A']++
        }

        // Max heap to store frequencies
        val pq = PriorityQueue<Int>(Collections.reverseOrder())
        for (i in 0..25) {
            if (freq[i] > 0) pq.offer(freq[i])
        }

        var time = 0
        // Process tasks until the heap is empty
        while (!pq.isEmpty()) {
            var cycle = n + 1
            val store = ArrayList<Int>()
            var taskCount = 0
            // Execute tasks in each cycle
            while (cycle > 0 && !pq.isEmpty()) {
                val currentFreq = pq.poll()
                if (currentFreq > 1) store.add(currentFreq - 1)
                taskCount++
                cycle--
            }
            // Restore updated frequencies to the heap
            store.forEach(Consumer { e: Int -> pq.offer(e) })
            // Add time for the completed cycle
            time += if (pq.isEmpty()) taskCount else n + 1
        }
        return time
    }
}
