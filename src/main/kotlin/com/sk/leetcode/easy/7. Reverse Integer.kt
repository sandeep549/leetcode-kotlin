package com.sk.leetcode.easy

class Solution7 {

    fun reverse2(x: Int): Int {
        var a = x
        var result = 0
        while (a != 0) {
            val pop = a % 10
            val tmp = result * 10 + pop
            if ((tmp - pop)/10 != result ) {
                return 0
            }
            result = tmp
            a /= 10
        }
        return result
    }
    fun reverse(x: Int): Int {
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
}