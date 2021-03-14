package leetcode.kotlin.array.easy

import kotlin.math.abs

private fun sortedSquares(nums: IntArray): IntArray {
    var l = 0
    var r = nums.lastIndex
    var k = nums.lastIndex
    val ans = IntArray(nums.size)
    while (l <= r) {
        if (abs(nums[r]) < abs(nums[l])) {
            ans[k] = nums[l] * nums[l]
            l++
        } else {
            ans[k] = nums[r] * nums[r]
            r--
        }
        k--
    }
    return ans
}