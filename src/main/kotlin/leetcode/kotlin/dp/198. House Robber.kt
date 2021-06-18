package leetcode.kotlin.dp

/**
 * f(n) = Max(              // max amount to robbed till n
 *           f(n-2) + A[n], // max amount robbed till n-2 and current house
 *           f(n-1)         // max amount robbed till n-1
 *           )
 */

private class SolutionDP {
    var max = 0
    lateinit var dp: IntArray
    fun rob(nums: IntArray): Int {
        dp = IntArray(nums.size) { -1 }
        robuntil(nums.lastIndex, nums)
        return dp.last()
    }

    private fun robuntil(i: Int, nums: IntArray): Int {
        if (i < 0) return 0
        if (dp[i] == -1) {
            dp[i] = maxOf(robuntil(i - 2, nums) + nums[i], robuntil(i - 1, nums))
        }
        return dp[i]
    }
}

private fun rob2(nums: IntArray): Int {
    var sl = 0 // second last house
    var l = 0 // last house
    for (n in nums) {
        val cur = maxOf(sl + n, l)
        sl = l
        l = cur
    }
    return l
}
