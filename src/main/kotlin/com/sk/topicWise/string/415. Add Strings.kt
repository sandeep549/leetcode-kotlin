package com.sk.topicWise.string

import java.lang.StringBuilder

class Solution415 {
    fun addStrings(num1: String, num2: String): String {
        var i = num1.length - 1
        var j = num2.length - 1
        var c = 0
        val ans = StringBuilder()
        val n1 = num1.toCharArray()
        val n2 = num2.toCharArray()
        while (i >= 0 || j >= 0 || c > 0) {
            if (i >= 0) c += n1[i--] - '0'
            if (j >= 0) c += n2[j--] - '0'
            ans.append(c % 10)
            c /= 10
        }
        return ans.reverse().toString()
    }
}
