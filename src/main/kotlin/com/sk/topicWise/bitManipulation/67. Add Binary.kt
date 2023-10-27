package com.sk.topicWise.bitManipulation

class Solution67 {
    fun addBinary(a: String, b: String): String {
        val ans = StringBuilder()
        var i = a.length - 1
        var j = b.length - 1
        var sum = 0
        var carry = 0
        while (i >= 0 || j >= 0 || carry > 0) {
            sum = carry
            if (i >= 0) sum += a[i--] - '0'
            if (j >= 0) sum += b[j--] - '0'
            ans.append(sum % 2)
            carry = sum / 2
        }
        return ans.reverse().toString()
    }
}
