package com.sk.set3

import java.util.*


class Solution347 {
    fun topKFrequent(nums: IntArray, k: Int): List<Int> {
        val frequencyMap: MutableMap<Int, Int> = HashMap()
        for (n in nums) {
            frequencyMap[n] = frequencyMap.getOrDefault(n, 0) + 1
        }

        val bucket = Array<MutableList<Int>?>(nums.size + 1) { null }
        for (key in frequencyMap.keys) {
            val frequency = frequencyMap[key]!!
            if (bucket[frequency] == null) {
                bucket[frequency] = ArrayList()
            }
            bucket[frequency]!!.add(key)
        }
        val res: MutableList<Int> = ArrayList()
        var pos = bucket.size - 1
        while (pos >= 0 && res.size < k) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]!!)
            }
            pos--
        }
        return res
    }
}

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
