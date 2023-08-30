package com.sk.leetcode.kotlin

fun main() {
    check(!isPowerOfThree(45))
    check(isPowerOfThree(81))
}

private fun isPowerOfThree(n: Int): Boolean {
    var no = n
    if (no < 1) {
        return false
    }

    while (no % 3 == 0) {
        no /= 3
    }

    return no == 1
}

private fun isPowerOfThree2(n: Int): Boolean {
    return when (n) {
        1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969, 14348907, 43046721, 129140163, 387420489, 1162261467 -> true
        else -> false
    }
}