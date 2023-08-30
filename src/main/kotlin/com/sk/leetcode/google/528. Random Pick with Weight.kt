package com.sk.leetcode.google


class Solution528_1(w: IntArray) {

    private val totalSum: Int
    private val prefixSum: IntArray

    init {
        prefixSum = IntArray(w.size)
        var sum = 0
        for (i in w.indices) {
            sum += w[i]
            prefixSum[i] = sum
        }
        totalSum = sum
    }

    fun pickIndex(): Int {
        val random = (0 until totalSum).random()
        for (i in prefixSum.indices) {
            if (random < prefixSum[i]) return i
        }
        return -1
    }
}


class Solution528_2(w: IntArray) {

    private var prefixSums: IntArray
    private var totalSum = 0

    init {
        prefixSums = IntArray(w.size)
        var prefixSum = 0
        for (i in w.indices) {
            prefixSum += w[i]
            prefixSums[i] = prefixSum
        }
        totalSum = prefixSum
    }

    fun pickIndex(): Int {
        val target = totalSum * Math.random()
        val index = prefixSums.binarySearch(target.toInt())
        if (index >= 0) return index + 1
        else return -(index + 1)
    }

}

class Solution528_3(w: IntArray) {
    private var prefixSums: IntArray
    private var totalSum = 0

    init {
        prefixSums = IntArray(w.size)
        var prefixSum = 0
        for (i in w.indices) {
            prefixSum += w[i]
            prefixSums[i] = prefixSum
        }
        totalSum = prefixSum
    }

    fun pickIndex(): Int {
        val len = prefixSums.size
        val target = totalSum * Math.random()
        var lo = 0
        var hi = len - 1
        // search position
        while (lo < hi) {
            val mid = lo + (hi - lo) / 2
            if (target > prefixSums[mid]) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }
        return lo
    }
}
