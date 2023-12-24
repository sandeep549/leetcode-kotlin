package com.sk.set29

class Solution2976 {
    fun minimumCost(source: String, target: String, original: CharArray, changed: CharArray, cost: IntArray): Long {
        var res = 0L
        val d = Array(26) { LongArray(26) { Int.MAX_VALUE.toLong() } }
        for (i in original.indices) {
            val s = original[i] - 'a'
            val t = changed[i] - 'a'
            d[s][t] = minOf(d[s][t], cost[i].toLong()) // Note that there may exist indices i, j such that original[j] == original[i] and changed[j] == changed[i].
        }
        for (k in 0 until 26) {
            for (i in 0 until 26) {
                for (j in 0 until 26) {
                    d[i][j] = minOf(d[i][j], d[i][k] + d[k][j])
                }
            }
        }
        for (i in source.indices) {
            if (source[i] == target[i]) {
                continue
            }
            val s = source[i] - 'a'
            val t = target[i] - 'a'
            if (d[s][t] >= Int.MAX_VALUE.toLong()) {
                return -1
            }
            res += d[s][t]
        }
        return res
    }


}