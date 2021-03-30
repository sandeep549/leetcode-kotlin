package leetcode.kotlin.bitManipulation

private fun singleNumber(nums: IntArray): IntArray {
    var diff = 0
    for (num in nums) {
        diff = diff xor num
    }
    diff = diff and -diff

    val rets = intArrayOf(0, 0)
    for (num in nums) {
        if (num and diff == 0) {
            rets[0] = rets[0] xor num
        } else {
            rets[1] = rets[1] xor num
        }
    }
    return rets
}