package com.sk.set19

class Solution1903 {
    fun largestOddNumber(num: String): String {
        for (i in num.indices.reversed()) {
            if (num[i].digitToInt() % 2 != 0) {
                return num.substring(0, i+1)
            }
        }
        return ""
    }
}