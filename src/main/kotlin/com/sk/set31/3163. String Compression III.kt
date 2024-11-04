package com.sk.set31

class Solution3163 {
    fun compressedString(word: String): String {
        var count = 1
        var ch = word[0]
        val sb = StringBuilder()
        for (i in 1..word.lastIndex) {
            if (word[i] == ch && count != 9) {
                count++
            } else {
                sb.append(count)
                sb.append(ch)
                ch = word[i]
                count = 1
            }
        }
        sb.append(count)
        sb.append(ch)
        return sb.toString()
    }
}