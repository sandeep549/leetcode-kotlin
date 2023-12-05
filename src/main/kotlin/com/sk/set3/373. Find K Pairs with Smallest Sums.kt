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


// https://leetcode.com/problems/find-k-pairs-with-smallest-sums/solutions/84551/simple-java-o-klogk-solution-with-explanation/comments/168485
class Solution373_1 {
    fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<IntArray> {
        var k = k
        val pq = PriorityQueue<IntArray> { a, b -> nums1[a[0]] + nums2[a[1]] - (nums1[b[0]] + nums2[b[1]])
        }
        val res: MutableList<IntArray> = ArrayList()
        var i = 0
        while (i < nums1.size && i < k) {
            pq.offer(intArrayOf(i, 0))
            i++
        }
        while (k-- > 0 && !pq.isEmpty()) {
            val cur = pq.poll()
            res.add(intArrayOf(nums1[cur[0]], nums2[cur[1]]))
            if (cur[1] == nums2.size - 1) continue  //Don't add the next index if there is no more left in 2nd array
            pq.offer(intArrayOf(cur[0], cur[1] + 1))
        }
        return res
    }
}