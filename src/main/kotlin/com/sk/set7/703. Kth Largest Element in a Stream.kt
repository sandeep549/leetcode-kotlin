package com.sk.set7

import java.util.PriorityQueue


class KthLargest(k: Int, nums: IntArray) {

    val pq = PriorityQueue<Int>()
    val max = k

    init {
        nums.forEach { element ->
            pq.add(element)
            if (pq.size > max) pq.remove()
        }
    }

    fun add(`val`: Int): Int {
        pq.add(`val`)
        if (pq.size > max) pq.remove()
        return pq.peek()
    }

}