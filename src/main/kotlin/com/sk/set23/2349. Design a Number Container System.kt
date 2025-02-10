package com.sk.set23

import java.util.*

class NumberContainers1() {
    private val indexToNumber = mutableMapOf<Int, Int>()
    private val numberToIndices = mutableMapOf<Int, TreeSet<Int>>()

    fun change(index: Int, number: Int) {
        // If index already has a number, remove the old mapping
        indexToNumber[index]?.let { oldNumber ->
            numberToIndices[oldNumber]?.remove(index)
            if (numberToIndices[oldNumber]?.isEmpty() == true) {
                numberToIndices.remove(oldNumber)
            }
        }

        // Update the mapping
        indexToNumber[index] = number
        numberToIndices.computeIfAbsent(number) { TreeSet() }.add(index)
    }

    fun find(number: Int): Int {
        return numberToIndices[number]?.firstOrNull() ?: -1
    }
}

class NumberContainers2 {
    private val indexToNumbers = mutableMapOf<Int, Int>()
    private val numberToIndices = mutableMapOf<Int, PriorityQueue<Int>>()

    fun change(index: Int, number: Int) {
        // Update index to number mapping
        indexToNumbers[index] = number

        // Add index to the min heap for this number
        numberToIndices.computeIfAbsent(number) { PriorityQueue() }.add(index)
    }

    fun find(number: Int): Int {
        // If number doesn't exist in our map
        val minHeap = numberToIndices[number] ?: return -1

        // Keep checking top element until we find valid index
        while (minHeap.isNotEmpty()) {
            val index = minHeap.peek()

            // If index still maps to our target number, return it
            if (indexToNumbers[index] == number) {
                return index
            }

            // Otherwise remove this stale index
            minHeap.poll()
        }

        return -1
    }
}