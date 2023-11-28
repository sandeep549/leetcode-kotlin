package com.sk.set1

private fun partition(s: String): List<List<String>> {
    val ans = mutableListOf<MutableList<String>>()
    fun isPalindrome(l: Int, r: Int): Boolean {
        var i = l
        var j = r
        while (i < j) if (s[i++] != s[j--]) return false
        return true
    }

    fun dfs(i: Int, list: MutableList<String>) {
        if (i >= s.length) ans.add(list.toMutableList())
        var k = 0
        while (i + k < s.length) {
            if (isPalindrome(i, i + k)) {
                list.add(s.substring(i, i + k + 1))
                dfs(i + k + 1, list)
                list.removeAt(list.size - 1)
            }
            k++
        }
    }
    dfs(0, mutableListOf())
    return ans
}

private fun partition2(s: String): List<List<String>> {
    val ans = mutableListOf<MutableList<String>>()
    val dp = Array(s.length) { BooleanArray(s.length) { false } }
    fun dfs(i: Int, list: MutableList<String>) {
        if (i >= s.length) ans.add(list.toMutableList())
        var k = 0
        while (i + k < s.length) {
            if (s[i] == s[i + k] && (k <= 2 || dp[i + 1][i + k - 1])) {
                dp[i][i + k] = true
                list.add(s.substring(i, i + k + 1))
                dfs(i + k + 1, list)
                list.removeAt(list.size - 1)
            }
            k++
        }
    }
    dfs(0, mutableListOf())
    return ans
}
