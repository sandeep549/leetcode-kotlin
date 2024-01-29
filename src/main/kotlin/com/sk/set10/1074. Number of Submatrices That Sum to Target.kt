package com.sk.set10

class Solution1074 {
    fun numSubmatrixSumTarget(A: Array<IntArray>, target: Int): Int {
        var res = 0
        val R = A.size
        val C = A[0].size

        // Calculate prefix sum for each row
        for (i in 0 until R) {
            for (j in 1 until C) {
                A[i][j] += A[i][j - 1]
            }
        }

        val counter= HashMap<Int, Int>()
        for (i in 0 until C) {
            for (j in i until C) {
                counter.clear()
                counter[0] = 1
                var cur = 0
                for (k in 0 until R) {
                    cur += A[k][j] - if (i > 0) A[k][i - 1] else 0
                    res += counter.getOrDefault(cur - target, 0)
                    counter[cur] = counter.getOrDefault(cur, 0) + 1
                }
            }
        }
        return res
    }
}