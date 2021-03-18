package leetcode.kotlin.backtracking

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