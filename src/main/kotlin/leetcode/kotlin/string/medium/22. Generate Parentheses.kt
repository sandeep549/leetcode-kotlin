package leetcode.kotlin.string.medium

fun main() {
    println(generateParenthesis2(3))
}

private fun generateParenthesis(n: Int): List<String> {
    val ans = mutableListOf<String>()
    val arr = CharArray(2 * n)
    fun isValid(arr: CharArray): Boolean {
        var count = 0
        for (ch in arr) {
            if (ch == '(') count++
            else count--
            if (count < 0) return false
        }
        return count == 0
    }

    fun generate(pos: Int) {
        if (pos == arr.size) {
            if (isValid(arr)) {
                ans.add(String(arr))
            }
        } else {
            arr[pos] = '('
            generate(pos + 1)
            arr[pos] = ')'
            generate(pos + 1)
        }
    }
    generate(0)
    return ans
}

private fun generateParenthesis2(n: Int): List<String?> {
    val ans = mutableListOf<String>()
    fun backtrack(cur: String, open: Int, close: Int) {
        if (cur.length == 2 * n) {
            ans.add(cur)
            return
        }
        if (open < n) backtrack("$cur(", open + 1, close)
        if (close < open) backtrack("$cur)", open, close + 1)
    }
    backtrack("", 0, 0)
    return ans
}
