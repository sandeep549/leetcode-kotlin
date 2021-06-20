package leetcode.kotlin.dp

/**
 * f(n) : Function to return minimum no of coins required to make n, return -1 otherwise.
 * f(n) = min{ 1 + f(n - arr[i]) }
 *  where  0 <= i < size and arr[i] <= n
 */

private class SolutionCoinChange {

    // Solution-1, simple recursive
    fun coinChange1(arr: IntArray, n: Int): Int {
        if (n == 0) return 0
        var res = Int.MAX_VALUE
        for (e in arr) {
            if (e <= n) {
                val r = coinChange1(arr, n - e)
                if (r != -1 && r + 1 < res) {
                    res = r + 1
                }
            }
        }
        if (res == Int.MAX_VALUE) res = -1
        return res
    }

    // Solution-2, DP, top-down
    fun coinChange2(arr: IntArray, n: Int): Int {
        val dp = IntArray(n + 1) { 0 }
        return topdown(arr, n, dp)
    }

    private fun topdown(arr: IntArray, n: Int, dp: IntArray): Int {
        if (n == 0) return 0
        if (dp[n] != 0) return dp[n]
        var res = Int.MAX_VALUE
        for (e in arr) {
            if (e <= n) {
                val r = topdown(arr, n - e, dp)
                if (r != -1 && r + 1 < res) {
                    res = r + 1
                }
            }
        }
        if (res == Int.MAX_VALUE) res = -1
        dp[n] = res
        return res
    }

    // Solution-3, dp, bottom-up
    fun coinChange3(coins: IntArray, amount: Int): Int {
        if (amount == 0) return 0
        val dp = IntArray(amount + 1)
        var sum = 0
        while (++sum <= amount) {
            var min = -1
            for (coin in coins) {
                if (sum >= coin && dp[sum - coin] != -1) {
                    val temp = dp[sum - coin] + 1
                    min = if (min < 0) temp else if (temp < min) temp else min
                }
            }
            dp[sum] = min
        }
        return dp[amount]
    }
}
