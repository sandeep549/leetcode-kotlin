package com.sk.leetcode.kotlin

private fun reverseStr(s: String, k: Int): String {
    val a = s.toCharArray()
    var start = 0
    while (start < a.size) {
        var i = start
        var j = minOf(start + k - 1, a.size - 1)
        while (i < j) {
            val tmp = a[i]
            a[i++] = a[j]
            a[j--] = tmp
        }
        start += 2 * k
    }
    return String(a)
}
