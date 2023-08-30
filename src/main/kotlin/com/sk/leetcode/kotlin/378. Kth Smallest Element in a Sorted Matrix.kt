package com.sk.leetcode.kotlin

import java.util.PriorityQueue

private class Solution3 {
    class Tuple(var r: Int, var c: Int, var `val`: Int) : Comparable<Tuple?> {
        override fun compareTo(other: Tuple?) = `val` - (other?.`val` ?: 0)
    }

    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        val n = matrix.size
        val pq = PriorityQueue<Tuple>()
        for (c in 0 until n) pq.offer(Tuple(0, c, matrix[0][c])) // O(n*logn)
        for (i in 0 until k - 1) { // O(k*logn)
            val t = pq.poll()
            if (t.r == n - 1) continue
            pq.offer(Tuple(t.r + 1, t.c, matrix[t.r + 1][t.c]))
        }
        return pq.poll().`val`
    }
}
