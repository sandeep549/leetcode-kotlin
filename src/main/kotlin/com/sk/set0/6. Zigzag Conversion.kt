package com.sk.set0


class Solution6 {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) return s
        val arr = Array<CharArray>(numRows) { CharArray(s.length) { '*' } }
        var r = 0
        var c = 0
        var down = true
        var i = 0
        while (i in s.indices) {
            println("r=$r, c=$c, i=$i")
            if (down) {
                arr[r][c] = s[i++]
                r++
                if (r == numRows) {
                    down = false
                    r -= 2
                    c++
                }
            } else {
                arr[r][c] = s[i++]
                r--
                c++
                if (r == -1) {
                    down = true
                    r += 2
                    c--
                }
            }
        }

        val s = StringBuilder()
        for (r in arr.indices) {
            for (c in arr[r].indices) {
                if (arr[r][c] != '*') s.append(arr[r][c])
            }
        }

        return s.toString()
    }

    fun convert2(s: String, numRows: Int): String {
        val length = s.length
        val sb = Array(numRows) { StringBuilder() }

        var i = 0
        while (i < length) {
            // vertically down
            var idx = 0
            while (idx < numRows && i < length) {
                sb[idx].append(s[i++])
                idx++
            }

            // obliquely up
            idx = numRows - 2
            while (idx >= 1 && i < length) {
                sb[idx].append(s[i++])
                idx--
            }
        }

        return sb.joinToString(separator = "")
    }

}
