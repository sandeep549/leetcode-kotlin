package leetcode.kotlin.misc

private fun singleNumber(nums: IntArray): Int {
    var res = 0
    for (i in nums) {
        res = res.xor(i)
    }
    return res
}

private fun singleNumber2(nums: IntArray): Int {
    return nums.reduce { acc, ele -> acc.xor(ele) }
}

private fun singleNumber3(nums: IntArray): Int {
    return nums.asSequence().groupBy { it }.mapValues { it.value.size }
        .filter { it.value == 1 }.keys.first()
    // return nums.groupBy { it }.mapValues { it.value.size }.filter { it.value == 1 }.keys.first()
}
