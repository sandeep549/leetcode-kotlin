package topicWise.dp

/**
 * f(n) = Max(              // max loot till n
 *           f(n-2) + A[n], // max loot till n-2 and loot current
 *           f(n-1)         // max loot till n-1
 *           )
 */

private class SolutionDP {
    var max = 0
    lateinit var dp: IntArray
    fun rob(nums: IntArray): Int {
        dp = IntArray(nums.size) { -1 }
        robupto(nums, nums.lastIndex)
        return dp.last()
    }

    private fun robupto(nums: IntArray, i: Int): Int {
        if (i < 0) return 0
        if (dp[i] == -1) {
            dp[i] = maxOf(
                robupto(nums, i - 2) + nums[i],
                robupto(nums, i - 1)
            )
        }
        return dp[i]
    }
}

private fun rob2(nums: IntArray): Int {
    var l = 0
    var sl = 0
    for(money in nums) {
        val here = maxOf(sl + money, l)
        sl = l
        l = here
    }
    return l
}
