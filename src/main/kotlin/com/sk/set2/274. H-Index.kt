package com.sk.set2

class Solution274 {
    fun hIndex(citations: IntArray): Int {
        val arr = citations.sorted()
        var h = 1
        for (i in arr.indices.reversed()) {
            if (arr[i] < h) {
                break
            }
            h++
        }
        return h - 1
    }

    fun hIndex2(citations: IntArray): Int {
        val n = citations.size
        val buckets = IntArray(n + 1)
        for (c in citations) {
            if (c >= n) {
                buckets[n]++
            } else {
                buckets[c]++
            }
        }
        var count = 0
        for (i in n downTo 0) {
            count += buckets[i]
            if (count >= i) {
                return i
            }
        }
        return 0
    }
}