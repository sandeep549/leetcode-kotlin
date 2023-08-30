package com.sk.topicWise.bitManipulation

private fun findNumber(nums: IntArray): Int {
    var ans = 0
    for (a in nums) {
        ans = ans.xor(a)
    }
    return ans
}
