package com.sk.topicWise.math

import kotlin.math.abs

private fun divide(dividend: Int, divisor: Int): Int {
    if (dividend == 1 shl 31 && divisor == -1) return (1 shl 31) - 1
    var a = abs(dividend)
    val b = abs(divisor)
    var res = 0
    var x = 0
    while (a - b >= 0) {
        x = 0
        while (a - (b shl x shl 1) >= 0) {
            x++
        }
        res += 1 shl x
        a -= b shl x
    }
    return if (dividend > 0 == divisor > 0) res else -res
}
