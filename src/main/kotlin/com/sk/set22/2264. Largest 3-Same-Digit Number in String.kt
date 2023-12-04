package com.sk.set22

class Solution {
    fun largestGoodInteger(num: String): String {
        var m = -1
        for (i in 2..num.lastIndex) {
            if (num[i] == num[i-1] && num[i] == num[i-2]) {
                m = maxOf(m, num[i].digitToInt())
            }
        }
        return if (m == -1) "" else "$m$m$m"
    }
}