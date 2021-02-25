package leetcode.kotlin

fun scoreOfParentheses(S: String): Int {
    fun score(S: String, l: Int, r: Int): Int {
        var l = l
        var ans = 0
        var bal = 0
        for (i in l until r) {
            bal += if (S[i] == '(') 1 else -1
            if (bal == 0) { // found primitive string
                val res = if (i - l == 1) 1 else score(S, l + 1, i) // process primitive string
                ans += res
                l = i + 1 // move to next primitive if exist
            }
        }
        return ans
    }
    return score(S, 0, S.length)
}
