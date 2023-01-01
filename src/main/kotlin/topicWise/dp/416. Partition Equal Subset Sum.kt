package topicWise.dp

private class SolutionEqualPartition {
    fun canPartition(nums: IntArray): Boolean {
        return internal(nums, nums.lastIndex, 0, 0)
    }

    /**
     * Recursion with optimal structure.
     * f(arr, i, s1, s2) = f(arr, i-1, s1 + arr[i], s2) || f(arr, i-1, s1, s2 + arr[i])
     */
    private fun internal(arr: IntArray, i: Int, s1: Int, s2: Int): Boolean {
        if (i < 0) {
            return s1 == s2
        }
        return internal(arr, i - 1, s1 + arr[i], s2) || internal(arr, i - 1, s1, s2 + arr[i])
    }

    fun canPartition2(nums: IntArray): Boolean {
        var sum = 0
        for (num in nums) {
            sum += num
        }
        if (sum and 1 == 1) {
            return false
        }
        sum /= 2
        val dp = BooleanArray(sum + 1)
        dp[0] = true
        for (num in nums) {
            for (i in sum downTo 1) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i - num]
                }
            }
        }
        return dp[sum]
    }
}
