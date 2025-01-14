package com.sk.set26

class Solution {
    fun findThePrefixCommonArray(A: IntArray, B: IntArray): IntArray {
        val n = A.size
        val freq = mutableMapOf<Int, Int>() // To count occurrences of elements in A and B
        val C = IntArray(n)
        var commonCount = 0

        for (i in 0 until n) {
            freq[A[i]] = freq.getOrDefault(A[i], 0) + 1
            if (freq[A[i]] == 2) commonCount++ // Element appears in both arrays

            freq[B[i]] = freq.getOrDefault(B[i], 0) + 1
            if (freq[B[i]] == 2) commonCount++ // Element appears in both arrays

            C[i] = commonCount
        }

        return C
    }
}