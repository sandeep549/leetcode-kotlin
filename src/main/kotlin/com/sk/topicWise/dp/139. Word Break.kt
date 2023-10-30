package com.sk.topicWise.dp

class Solution139 {

    // dp, bottom-up
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val dp = BooleanArray(s.length)
        val dict = wordDict.toSet()
        for (i in s.indices) {
            for (j in i downTo 0) {
                //val part1 = s.substring(0, j+1)
                val part2 = s.substring(j, i + 1)
                if ((j - 1 < 0 || dp[j - 1]) && dict.contains(part2)) {
                    dp[i] = true
                    break
                }
            }
        }
        return dp[s.lastIndex]
    }
}


// Recursion, time limit exceeded
private fun wordBreak(s: String, wordDict: List<String>): Boolean {
    var set = wordDict.toSet()
    fun isWord(start: Int, end: Int) = set.contains(s.substring(start, end + 1))
    fun canBreak(start: Int, end: Int): Boolean {
        if (start > end) return true
        var res = false
        for (j in start..end) {
            if (isWord(start, j) && canBreak(j + 1, end)) {
                res = true
                break
            }
        }
        return res
    }
    return canBreak(0, s.lastIndex)
}

// dp, bottom-up, recursive
// O(n^2)
// O(n)
private fun wordBreak2(s: String, wordDict: List<String>): Boolean {
    var set = wordDict.toSet()
    var table = Array<Boolean?>(s.length + 1) { null }
    fun isWord(start: Int, end: Int) = set.contains(s.substring(start, end + 1))
    fun canBreak(start: Int, end: Int): Boolean {
        if (start > end) return true
        table[start]?.let { return it }
        var res = false
        for (j in start..end) {
            if (isWord(start, j) && canBreak(j + 1, end)) {
                table[j + 1] = true
                res = true
                break
            }
        }
        table[start] = res
        return res
    }
    return canBreak(0, s.lastIndex)
}

// dp, bottom-up, iterative
// O(n^2)
// O(n)
fun wordBreak3(s: String, wordDict: List<String?>): Boolean {
    val set = wordDict.toSet()
    val dp = BooleanArray(s.length + 1)
    dp[0] = true
    for (i in 1..s.length) {
        for (j in 0 until i) {
            if (dp[j] && set.contains(s.substring(j, i))) {
                dp[i] = true
                break
            }
        }
    }
    return dp[s.length]
}
