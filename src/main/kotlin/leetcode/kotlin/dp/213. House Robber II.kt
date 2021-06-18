package leetcode.kotlin.dp

/**
 * f(n) = Max(              // max amount to robbed till n
 *           f(n-2) + A[n], // max amount robbed till n-2 and current house
 *           f(n-1)         // max amount robbed till n-1
 *           )
 */

private fun rob2(nums: IntArray): Int {
    if (nums.size == 1) return nums[0]
    fun maxx(a: Int, b: Int): Int {
        var sl = 0
        var l = 0
        for (i in a..b) {
            val m = Math.max(sl + nums[i], l)
            sl = l
            l = m
        }
        return l
    }
    return maxOf(
        maxx(0, nums.size - 2), // find including first
        maxx(1, nums.size - 1) // find including last
    )
}

private class CircularRobbing {
    fun rob(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]
        return maxOf(robinternal(nums, 0, nums.lastIndex - 1), robinternal(nums, 1, nums.lastIndex))
    }

    private fun robinternal(nums: IntArray, start: Int, end: Int): Int {
        var sl = 0
        var l = 0
        for (i in start..end) {
            var cur = maxOf(sl + nums[i], l)
            sl = l
            l = cur
        }
        return l
    }
}

