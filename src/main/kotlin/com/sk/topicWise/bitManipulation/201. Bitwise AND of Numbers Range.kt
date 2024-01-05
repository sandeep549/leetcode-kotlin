package com.sk.topicWise.bitManipulation

class Solution201 {
    fun rangeBitwiseAnd(m: Int, n: Int): Int {
        var m = m
        var n = n
        var i = 0
        while (m != n) {
            m = m shr 1
            n = n shr 1
            i++
        }
        return m shl i
    }
}