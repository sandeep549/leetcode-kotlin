package leetcode.kotlin.dp

/**
 * f(n) = Max(              // max amount to robbed till n
 *           f(n-2) + A[n], // max amount robbed till n-2 and current house
 *           f(n-1)         // max amount robbed till n-1
 *           )
 */
private fun rob(nums: IntArray): Int {
    val dp = IntArray(nums.size) { -1 }
    fun robi(i: Int): Int {
        if (i < 0) return 0
        if (i == 0) return nums[i]
        if (dp[i] == -1) {
            dp[i] = maxOf(robi(i - 2) + nums[i], robi(i - 1))
        }
        return dp[i]
    }
    return robi(nums.lastIndex)
}

private fun rob2(nums: IntArray): Int {
    var sl = 0 // second last house
    var l = 0 // last house
    for (n in nums) {
        val cur = Math.max(sl + n, l)
        sl = l
        l = cur
    }
    return l
}
