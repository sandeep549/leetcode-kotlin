package com.sk.leetcode.kotlin

private fun toLowerCase(str: String): String {
    val a = str.toCharArray()
    for (i in a.indices) {
        if (a[i] in 'A'..'Z') a[i] = (a[i].toInt() + 32).toChar()
    }
    return String(a)
}