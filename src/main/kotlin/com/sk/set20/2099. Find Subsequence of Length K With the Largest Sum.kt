package com.sk.set20

import java.util.PriorityQueue

class Solution2099 {
    fun maxSubsequence(nums: IntArray, k: Int): IntArray {
        val minHeap = PriorityQueue<Pair<Int, Int>> { o1, o2 -> o1.first.compareTo(o2.first) }
        nums.forEachIndexed() { index, item ->
            minHeap.add(Pair(item, index))
            if (minHeap.size > k) minHeap.poll()
        }

        return minHeap.toMutableList()
            .sortedWith(Comparator { o1, o2 -> o1.second.compareTo(o2.second) })
            .map { it.first }
            .toIntArray()
    }

    fun maxSubsequence2(nums: IntArray, k: Int): IntArray {
        if (k == nums.size) return nums

        val list = nums.toMutableList()
        list.sortDescending()
        val kthValue = list[k - 1]
        val res = mutableListOf<Int>()
        var cnt = list.take(k).count { it == kthValue }

        for (num in nums) {
            if (num > kthValue || (num == kthValue && cnt-- > 0)) {
                res.add(num)
            }
        }
        return res.toIntArray()
    }
}