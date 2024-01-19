package com.sk.topicWise.monotonicStack

class Solution739 {
    fun dailyTemperatures(A: IntArray): IntArray {
        val ans = IntArray(A.size)
        val s = ArrayDeque<Int>()
        for (i in A.indices) {
            while (s.isNotEmpty() && A[s.last()] < A[i]) {
                val idx = s.removeLast()
                ans[idx] = i - idx
            }
            s.addLast(i)
        }
        return ans
    }
}