package com.sk.medium

class Solution997 {
    fun findJudge(n: Int, trust: Array<IntArray>): Int {
        val d = IntArray(n + 1)
        for (t in trust) {
            d[t[0]]-- // out-degree
            d[t[1]]++ // in-degree
        }
        for (i in 1..n + 1) {
            if (d[i] == n - 1) return i
        }
        return -1
    }
}