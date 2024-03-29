package com.sk.topicWise.twopointer

private fun reverseString(s: CharArray) {
    var l = 0
    var r = s.size - 1
    while (l < r) {
        s[l] = s[r].also { s[r] = s[l] }
        l++
        r--
    }
}
