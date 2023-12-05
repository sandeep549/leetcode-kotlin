package com.sk.set3

import java.util.*


class Solution373 {

    // TLE
    fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
        val q = PriorityQueue<Pair<Int, List<Int>>> { p1, p2 -> p1.first - p2.first }
        for (u in nums1) {
            for (v in nums2) {
                q.add(Pair(u + v, mutableListOf(u, v)))
            }
        }
        val res = mutableListOf<MutableList<Int>>()
        var count = 0
        while (count < k && q.isNotEmpty()) {
            res.add(q.poll().second.toMutableList())
            count++
        }
        return res
    }

    fun kSmallestPairs2(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
        var k = k
        val que = PriorityQueue<IntArray> { a, b -> a[0] + a[1] - b[0] - b[1] }
        val res = mutableListOf<List<Int>>()
        var i = 0
        while (i < nums2.size && i < k) {
            que.offer(intArrayOf(nums1[0], nums2[i], 0))
            i++
        }
        while (k-- > 0 && que.isNotEmpty()) {
            val cur = que.poll()
            res.add(listOf(cur[0], cur[1]))
            val idx1 = cur[2]
            if (idx1 == nums1.size - 1) continue
            que.offer(intArrayOf(cur[idx1+1], cur[1], idx1 + 1))
        }
        return res
    }
}