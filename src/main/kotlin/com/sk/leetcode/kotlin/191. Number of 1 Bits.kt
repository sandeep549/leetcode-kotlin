package com.sk.leetcode.kotlin

fun main() {
    println(hammingWeight(-2147483648))
}

private fun hammingWeight(n: Int): Int {
    var num = n
    var count = 0
    while (num != 0) {
        if (num and 1 == 1) count++
        num = num.ushr(1)
    }
    return count
}

private fun hammingWeight2(n: Int): Int {
    var n = n
    var sum = 0
    while (n != 0) {
        sum++
        n = n and n - 1
    }
    return sum
}