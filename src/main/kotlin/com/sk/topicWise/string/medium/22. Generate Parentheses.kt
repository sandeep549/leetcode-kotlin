package com.sk.topicWise.string.medium

class Solution22 {

    fun generateParenthesis(n: Int): List<String> {
        val ans = ArrayList<String>()
        val arr = CharArray(2 * n)

        generate(0, arr, ans)
        return ans
    }

    fun generate(pos: Int, arr: CharArray, ans: ArrayList<String>) {
        // Check if its valid at last and add to result
        if (pos == arr.size) {
            if (isValid(arr)) {
                ans.add(String(arr))
            }
        } else {
            // We have 2 choices at every position
            arr[pos] = '('
            generate(pos + 1, arr, ans)
            arr[pos] = ')'
            generate(pos + 1, arr, ans)
        }
    }

    fun isValid(arr: CharArray): Boolean {
        var count = 0
        for (ch in arr) {
            if (ch == '(') count++
            else count--
            if (count < 0) return false
        }
        return count == 0
    }

    fun generateParenthesis2(n: Int): List<String> {
        val ans = ArrayList<String>()
        backtrack("", 0, 0, n, ans)
        return ans
    }

    fun backtrack(cur: String, open: Int, close: Int, n: Int, ans: ArrayList<String>) {
        if (cur.length == 2 * n) {
            ans.add(cur)
            return
        }
        // we have 2 choices here but with valid preconditions
        if (open < n) backtrack("$cur(", open + 1, close, n, ans)
        if (close < open) backtrack("$cur)", open, close + 1, n, ans)
    }

}