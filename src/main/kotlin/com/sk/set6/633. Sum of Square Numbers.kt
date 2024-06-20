package com.sk.set6

class Solution633 {
    fun judgeSquareSum(c: Int): Boolean {
        var a = 0L
        while (a * a <= c) {
            val b = c - (a * a).toInt()
            if (binarySearch(0L, b.toLong(), b)) return true
            a++
        }
        return false
    }

    private fun binarySearch(s: Long, e: Long, n: Int): Boolean {
        var l = s
        var r = e
        while (l <= r) {
            val mid = l + (r - l) / 2
            val midValue = mid * mid
            if (midValue == n.toLong()) return true
            else if (midValue > n) r = mid - 1
            else l = mid + 1
        }
        return false
    }
}
