package com.sk.leetcode.kotlin

private fun trailingZeroes(n: Int): Int {
    var n = n
    var cnt = 0
    while (n > 0) {
        cnt += n / 5
        n /= 5
    }
    return cnt
}