package leetcode.kotlin.dp

private fun coinChange(coins: IntArray, amount: Int): Int {
    val dp = IntArray(amount + 1) { -1 }

    fun getMinCountForAmount(amount: Int): Int {
        if (amount == 0) return 0
        if (dp[amount] != -1) return dp[amount]
        var min = Int.MAX_VALUE
        for (coin in coins) {
            if (amount - coin >= 0) {
                val m = getMinCountForAmount(amount - coin)
                if (m in 0 until min) {
                    min = minOf(min, m + 1)
                }
            }
        }
        dp[amount] = if (min == Int.MAX_VALUE) -1 else min
        return dp[amount]
    }

    val ans = getMinCountForAmount(amount)
    return if (ans < 0) -1 else ans
}

private fun coinChange2(coins: IntArray, amount: Int): Int {
    if (amount < 1) return 0
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
