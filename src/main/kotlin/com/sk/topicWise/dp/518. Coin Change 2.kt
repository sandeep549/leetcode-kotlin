package com.sk.topicWise.dp

private class SolutionCoinChange2 {
    fun change(amount: Int, coins: IntArray): Int {
        return internal(coins, coins.size, amount)
    }

    // recursion with optimal structure property
    // f(arr, index, amount) -> Returns no of ways to build amount from arr using upto index
    // f(arr, index, amount) = f(arr, index-1, M) + f(arr, index, M-arr[index-1])
    private fun internal(arr: IntArray, index: Int, amount: Int): Int {
        if (amount == 0) return 1
        if (amount < 0) return 0
        if (index <= 0 && amount >= 1) return 0
        // excluding index coin and including index coin
        return internal(arr, index - 1, amount) + internal(arr, index, amount - arr[index - 1])
    }

    // Solution-2, using dp, top down

    lateinit var dp: Array<IntArray>
    fun change2(amount: Int, coins: IntArray): Int {
        dp = Array(coins.size + 1) { IntArray(amount + 1) { -1 } }
        return internal2(coins, coins.size, amount)
    }

    // recursion with optimal structure property
    // f(arr, index, amount) -> Returns no of ways to build amount from arr using upto index
    // f(arr, index, amount) = f(arr, index-1, M) + f(arr, index, M-arr[index-1])
    private fun internal2(arr: IntArray, index: Int, amount: Int): Int {
        if (amount == 0) return 1
        if (amount < 0) return 0
        if (index <= 0 && amount >= 1) return 0
        // excluding index coin and including index coin
        if (dp[index][amount] == -1) {
            dp[index][amount] = internal2(arr, index - 1, amount) +
                internal2(arr, index, amount - arr[index - 1])
        }
        return dp[index][amount]
    }

    // Solution-4, dp, bottom up, 2d array
    fun change3(amount: Int, coins: IntArray): Int {
        val dp = Array(coins.size + 1) { IntArray(amount + 1) }
        dp[0][0] = 1
        for (j in 1..coins.size) {
            dp[j][0] = 1
            for (i in 1..amount) {
                dp[j][i] = dp[j - 1][i] // i amount using without using jth coins
                if (i - coins[j - 1] >= 0) {
                    dp[j][i] += dp[j][i - coins[j - 1]] // Add amount with certainly using jth amount
                }
            }
        }
        return dp[coins.size][amount]
    }

    // Solution-4, dp, bottom up, 1d array
    fun change4(amount: Int, coins: IntArray): Int {
        val dp = IntArray(amount + 1)
        dp[0] = 1
        for (j in coins.indices) {
            for (i in 1..amount) {
                if (i - coins[j] >= 0) {
                    dp[i] += dp[i - coins[j]]
                }
            }
        }
        return dp[amount]
    }
}
