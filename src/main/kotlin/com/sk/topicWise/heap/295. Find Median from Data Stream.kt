package com.sk.topicWise.heap

import java.util.*

class MedianFinder_295() {
    private val leftHalf = PriorityQueue<Int>(reverseOrder())
    private val rightHalf = PriorityQueue<Int>()
    private var addToRight = true

    fun findMedian(): Double {
        return if (leftHalf.size == rightHalf.size) {
            (leftHalf.peek() + rightHalf.peek()) / 2.0
        } else {
            leftHalf.peek().toDouble()
        }
    }

    fun addNum(num: Int) {
        if (addToRight) {
            rightHalf.offer(num)
            leftHalf.offer(rightHalf.poll())
        } else {
            leftHalf.offer(num)
            rightHalf.offer(leftHalf.poll())
        }
        addToRight = !addToRight
    }

}
