package com.sk.leetcode.kotlin

import java.util.PriorityQueue

private fun topKFrequent(nums: IntArray, k: Int): IntArray {
    if (k == nums.size) {
        return nums
    }

    val count = nums.groupBy { it }.mapValues { it.value.size }

    val heap = PriorityQueue<Int> { n1, n2 -> (count[n1]!! - count[n2]!!) }

    for (n in count.keys) {
        heap.add(n)
        if (heap.size > k) heap.poll()
    }

    val top = IntArray(k)
    for (i in k - 1 downTo 0) {
        top[i] = heap.poll()
    }
    return top
}

private fun topKFrequent2(nums: IntArray, k: Int) = nums
    .groupBy { it } // Time: O(n) Space:O(n)
    .toList() // Time: O(n) Space:O(n)
    .sortedByDescending { it.second.size } // Time: O(nlogn) Space:O(n)
    .take(k) // Time: O(k) Space:O(k)
    .map { it.first } // Time: O(k) Space:O(k)
