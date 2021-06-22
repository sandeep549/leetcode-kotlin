package leetcode.kotlin.dp

private class SolutionOneAndZero {
    // Solution-1, recursion
    fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
        val arr = Array(strs.size) { IntArray(2) { 0 } }
        for (i in strs.indices) {
            var one = 0
            var zero = 0
            for (ch in strs[i]) {
                if (ch == '1') one++ else zero++
            }
            arr[i][0] = zero
            arr[i][1] = one
        }
        return foo(arr, strs.lastIndex, m, n)
    }

    private fun foo(arr: Array<IntArray>, index: Int, available0: Int, available1: Int): Int {
        if (index < 0 || (available0 == 0 && available1 == 0)) return 0

        if (available0 < arr[index][0] || available1 < arr[index][1]) {
            return foo(arr, index - 1, available0, available1)
        }

        val include = 1 + foo(arr, index - 1, available0 - arr[index][0], available1 - arr[index][1])
        val exclude = foo(arr, index - 1, available0, available1)
        return maxOf(include, exclude)
    }

    // Solution-2, dp top down
    fun findMaxForm1(strs: Array<String>, m: Int, n: Int): Int {
        val arr = Array(strs.size) { IntArray(2) { 0 } }
        for (i in strs.indices) {
            var one = 0
            var zero = 0
            for (ch in strs[i]) {
                if (ch == '1') one++ else zero++
            }
            arr[i][0] = zero
            arr[i][1] = one
        }
        val dp = Array(strs.size) { Array(m + 1) { IntArray(n + 1) { -1 } } }
        return foo1(arr, strs.lastIndex, m, n, dp)
    }

    private fun foo1(
        arr: Array<IntArray>,
        index: Int,
        available0: Int,
        available1: Int,
        dp: Array<Array<IntArray>>
    ): Int {
        if (index < 0 || (available0 == 0 && available1 == 0)) return 0

        if (dp[index][available0][available1] != -1) {
            return dp[index][available0][available1]
        }

        if (available0 < arr[index][0] || available1 < arr[index][1]) {
            dp[index][available0][available1] = foo1(arr, index - 1, available0, available1, dp)
            return dp[index][available0][available1]
        }

        val include = 1 + foo1(arr, index - 1, available0 - arr[index][0], available1 - arr[index][1], dp)
        val exclude = foo1(arr, index - 1, available0, available1, dp)
        dp[index][available0][available1] = maxOf(include, exclude)
        return dp[index][available0][available1]
    }

    // Solution-3, dp bottom up
    fun findMaxForm2(strs: Array<String>, m: Int, n: Int): Int {
        val dp = Array(m + 1) { IntArray(n + 1) { 0 } }
        for (str in strs) {
            val x = str.filter { it == '1' }.length
            val y = str.length - x
            for (i in m downTo y) {
                for (j in n downTo x) {
                    dp[i][j] = maxOf(dp[i][j], 1 + dp[i - y][j - x])
                }
            }
        }
        return dp[m][n]
    }
}