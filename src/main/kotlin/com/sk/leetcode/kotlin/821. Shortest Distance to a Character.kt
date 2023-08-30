package com.sk.leetcode.kotlin

import kotlin.math.abs
import kotlin.math.min

fun main() {
    check(
        shortestToChar("loveleetcode", 'e')
            .contentEquals(intArrayOf(3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0))
    )
    check(
        shortestToChar2("loveleetcode", 'e')
            .contentEquals(intArrayOf(3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0))
    )
}

private fun shortestToChar(s: String, c: Char): IntArray {
    val ans = IntArray(s.length)
    var lastSeenIndex = -10000
    for (i in 0..s.lastIndex) {
        if (s[i] == c) lastSeenIndex = i
        ans[i] = i - lastSeenIndex
    }
    lastSeenIndex = 10000
    for (i in s.lastIndex downTo 0) {
        if (s[i] == c) lastSeenIndex = i
        ans[i] = min(ans[i], lastSeenIndex - i)
    }
    return ans
}

private fun shortestToChar2(s: String, c: Char): IntArray {
    val max: Int = 10000
    val ans = IntArray(s.length) { Int.MAX_VALUE }
    for (i in 0..s.lastIndex) {
        if (s[i] != c) continue
        for (j in 0..s.lastIndex) {
            val d = min(abs(i - j), ans[j])
            ans[j] = d
        }
    }
    return ans
}