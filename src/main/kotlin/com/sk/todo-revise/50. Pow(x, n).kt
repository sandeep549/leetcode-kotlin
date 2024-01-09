package com.sk.`todo-revise`

class Solution50 {
    fun myPow(x: Double, n: Int): Double {
        var x = x
        var n = n
        if (n < 0) {
            n = -n
            x = 1 / x
        }
        var pow = 1.0
        while (n != 0) {
            if (n and 1 != 0) {
                pow *= x
            }
            x *= x
            n = n ushr 1
        }
        return pow
    }
}
