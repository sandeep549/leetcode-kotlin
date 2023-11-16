package com.sk.leetcode.kotlin


class Solution14 {
    fun longestCommonPrefix(strs: Array<String>): String {
        val common = StringBuilder()
        if (strs.isEmpty()) return common.toString()
        for (index in 0 until strs[0].length) {
            val ch = strs[0][index]
            for (str in 1 until strs.size) {
                if (index >= strs[str].length || strs[str][index] != ch) {
                    return common.toString()
                }
            }
            common.append(ch)
        }
        return common.toString()
    }

    fun longestCommonPrefix2(v: Array<String>): String {
        val ans = StringBuilder()
        v.sort()
        val first = v[0]
        val last = v[v.size - 1]
        for (i in 0 until Math.min(first.length, last.length)) {
            if (first[i] != last[i]) {
                return ans.toString()
            }
            ans.append(first[i])
        }
        return ans.toString()
    }
}