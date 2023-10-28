package com.sk.topicWise.binarysearch

class Solution69 {

    // brute force
    fun mySqrt(x: Int): Int {
        var i = 1
        while (i <= x / i) {
            i++
        }
        return i - 1
    }

    // TODO: 14/2/21 try to remove long
    // newton's method
    // O(lg(x))
    fun mySqrt2(x: Int): Int {
        if (x == 0) return 0
        var i = x.toLong()
        while (i > x / i) {
            i = (i + x / i) / 2
        }
        return i.toInt()
    }

    // binary search
    // O(lg(x))
    fun mySqrt3(x: Int): Int {
        var l = 1
        var r = x
        var mid = 0
        while (l < r) {
            mid = l + (r - l) / 2
            if (mid < x / mid) l = mid + 1
            else r = mid
        }
        return if (l == x / l) l else l - 1
    }

}

