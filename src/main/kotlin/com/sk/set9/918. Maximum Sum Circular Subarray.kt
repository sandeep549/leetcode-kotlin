package com.sk.set9

class Solution918 {
    fun maxSubarraySumCircular(A: IntArray): Int {
        var total = 0
        var maxSum = A[0]
        var curMax = 0
        var minSum = A[0]
        var curMin = 0
        for (a in A) {
            curMax = maxOf(curMax + a, a)
            maxSum = maxOf(maxSum, curMax)
            curMin = minOf(curMin + a, a)
            minSum = minOf(minSum, curMin)
            total += a
        }
        return if (maxSum > 0) maxOf(maxSum, total - minSum) else maxSum
    }
}