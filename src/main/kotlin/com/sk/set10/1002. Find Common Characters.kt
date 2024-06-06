package com.sk.set10


class Solution1002 {
    fun commonChars(A: Array<String>): List<String> {
        var freq = count(A[0])
        for (i in 1 until A.size) {
            freq = intersection(freq, count(A[i]))
        }
        val list = mutableListOf<String>()
        for (i in 0..25) {
            repeat(freq[i]) { list.add("${'a' + i}") }
        }
        return list
    }

    fun intersection(a: IntArray, b: IntArray): IntArray {
        val t = IntArray(26)
        for (i in 0..25) {
            t[i] = minOf(a[i], b[i])
        }
        return t
    }

    fun count(str: String): IntArray {
        val t = IntArray(26)
        for (c in str.toCharArray()) t[c.code - 'a'.code]++
        return t
    }
}