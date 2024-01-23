package com.sk.set12

class Solution1239 {
    private fun isUnique(str: String): Boolean {
        if (str.length > 26) return false
        val used = BooleanArray(26)
        val arr = str.toCharArray()
        for (ch in arr) {
            if (used[ch - 'a']) {
                return false
            } else {
                used[ch - 'a'] = true
            }
        }
        return true
    }

    fun maxLength(arr: List<String>): Int {
        val res = ArrayList<String>()
        res.add("")
        for (str in arr) {
            if (!isUnique(str)) continue
            val resList = ArrayList<String>()
            for (candidate in res) {
                val temp = candidate + str
                if (isUnique(temp)) {
                    resList.add(temp)
                }
            }
            res.addAll(resList)
        }
        var ans = 0
        for (str in res) {
            ans = maxOf(ans, str.length)
        }
        return ans
    }
}