package com.sk.set18

import java.util.Collections
import java.util.PriorityQueue

class MKAverage(m: Int, k: Int) {
    val dq = ArrayDeque<Int>()
    val M = m
    val K = k

    fun addElement(num: Int) {
        dq.addLast(num)
        if (dq.size > M) dq.removeFirst()
    }

    fun calculateMKAverage(): Int {
        if (dq.size < M) return -1
        val minHeap = PriorityQueue<Int>()
        dq.forEach { element ->
            minHeap.add(element)
        }
        repeat(K) { minHeap.poll() }
        val maxHeap = PriorityQueue<Int>(Collections.reverseOrder())
        maxHeap.addAll(minHeap)
        repeat(K) { maxHeap.poll() }

        return maxHeap.average().toInt()
    }

}