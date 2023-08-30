package com.sk

import java.util.HashMap

private fun fourSumCount(A: IntArray, B: IntArray, C: IntArray, D: IntArray): Int {
    val map: MutableMap<Int, Int> = HashMap()
    for (i in C.indices) {
        for (j in D.indices) {
            val sum = C[i] + D[j]
            map[sum] = map.getOrDefault(sum, 0) + 1
        }
    }
    var res = 0
    for (i in A.indices) {
        for (j in B.indices) {
            res += map.getOrDefault(-1 * (A[i] + B[j]), 0)
        }
    }
    return res
}
