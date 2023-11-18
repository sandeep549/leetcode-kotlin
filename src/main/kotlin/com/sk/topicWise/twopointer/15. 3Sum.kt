package com.sk.topicWise.twopointer

// O(n^2)
private fun threeSum(num: IntArray): List<List<Int>> {
    num.sort()
    val res = mutableListOf<List<Int>>()
    for (i in 0 until num.size - 2) {
        if (i == 0 || i > 0 && num[i] != num[i - 1]) { // skip same
            var lo = i + 1
            var hi = num.lastIndex
            val target = 0 - num[i]
            while (lo < hi) {
                if (num[lo] + num[hi] == target) {
                    res.add(listOf(num[i], num[lo], num[hi]))
                    while (lo < hi && num[lo] == num[lo + 1]) lo++ // skip same
                    while (lo < hi && num[hi] == num[hi - 1]) hi-- // skip same
                    lo++
                    hi--
                } else if (num[lo] + num[hi] < target) lo++ else hi--
            }
        }
    }
    return res
}

class Solution15 {
    fun threeSum(num: IntArray): List<List<Int>> {
        num.sort()
        val res = mutableListOf<List<Int>>()
        for (i in 0 until num.size - 2) {
            if (i > 0 && num[i] == num[i - 1]) continue  // skip same
            var lo = i + 1
            var hi = num.lastIndex
            val target = 0 - num[i]
            while (lo < hi) {
                if (num[lo] + num[hi] == target) {
                    res.add(listOf(num[i], num[lo], num[hi]))
                    while (lo < hi && num[lo] == num[lo + 1]) lo++ // skip same
                    while (lo < hi && num[hi] == num[hi - 1]) hi-- // skip same
                    lo++
                    hi--
                } else if (num[lo] + num[hi] < target) {
                    lo++
                } else {
                    hi--
                }
            }
        }
        return res
    }
}
