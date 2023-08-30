package com.sk.leetcode.kotlin

private fun countAndSay(n: Int): String {
    if (n == 1) return "1"
    var str = countAndSay(n - 1)
    var ch = ' '
    var count = 0
    val ans = StringBuilder()
    str.forEach { digit ->
        if (digit != ch) {
            if (ch != ' ') ans.append(count).append(ch)
            ch = digit
            count = 1
        } else {
            count++
        }
    }
    return ans.append(count).append(ch).toString()
}