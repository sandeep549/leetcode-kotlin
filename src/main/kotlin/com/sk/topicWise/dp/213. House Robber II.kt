package com.sk.topicWise.dp

/**
 * f(n) = Max(              // max loot till n
 *           f(n-2) + A[n], // max loot till n-2 and loot current
 *           f(n-1)         // max loot till n-1
 *           )
 */

private fun rob(nums: IntArray): Int {
    if(nums.size == 1) return nums[0]
    return maxOf(
        tryrob(nums, 0, nums.lastIndex - 1), // don't rab last
        tryrob(nums, 1, nums.lastIndex) // don't rob first
    )
}

private fun tryrob(nums: IntArray, start: Int, end: Int): Int {
    var l = 0
    var sl = 0
    for (i in start..end) {
        val here = maxOf(sl + nums[i], l)
        sl = l
        l = here
    }
    return l
}
