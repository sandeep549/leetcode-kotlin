package com.sk.leetcode.easy

class Solution338 {
    fun countBits(n: Int): IntArray {
        if(n == 0) return intArrayOf(0)
        val arr = IntArray(n+1)
        var i = 1
        while(i <= n) {
            arr[i] = 1
            for(d in 1 until i) {
                if(i+d <= n) arr[i+d] = arr[d] + 1
            }
            i *= 2
        }
        return arr
    }
}