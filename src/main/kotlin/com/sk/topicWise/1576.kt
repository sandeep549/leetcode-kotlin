package com.sk.topicWise

import java.lang.StringBuilder

class Solution1576 {

    fun modifyString(s: String): String {
        val arr = s.toCharArray()
        for (i in s.indices) {
            if (s[i] == '?') {
                for (j in 0 until 3) {
                    if (i > 0 && arr[i-1] - 'a' == j) continue
                    if (i + 1 < arr.size && arr[i+1]-'a' == j) continue
                    arr[i] = 'a' +j
                    break
                }
            }
        }
        return String(arr)
    }

    fun modifyString2(s: String): String {
        val sb = StringBuilder()
        for (i in s.indices) {
            var curr = 'a'
            if (s[i] == '?') {
                while ( (i > 0 && curr == sb[i-1]) || ( i < s.lastIndex && curr == s[i+1])) {
                    curr += 1
                }
            } else {
                curr = s[i]
            }
            sb.append(curr)
        }
        return sb.toString()
    }
}

fun main() {
    val s = Solution1576()
    println(s.modifyString("?zs"))
    println(s.modifyString("ubv?w"))
    println(s.modifyString("y?z"))
}