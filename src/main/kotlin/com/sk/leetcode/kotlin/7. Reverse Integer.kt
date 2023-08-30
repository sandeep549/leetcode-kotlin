package com.sk.leetcode.kotlin

private fun reverse2(x: Int): Int {
    var a = x
    var result = 0
    while (a != 0) {
        val pop = a % 10
        if (result > Int.MAX_VALUE / 10 ||
            result == Int.MAX_VALUE / 10 && pop > 7
        ) {
            return 0
        }
        if (result < Int.MIN_VALUE / 10 ||
            result == Int.MIN_VALUE / 10 && pop == -8
        ) {
            return 0
        }
        result = result * 10 + pop
        a /= 10
    }
    return result
}
