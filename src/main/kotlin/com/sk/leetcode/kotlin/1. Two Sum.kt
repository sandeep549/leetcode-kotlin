package com.sk.leetcode.kotlin

fun main() {
    println(twoSum(intArrayOf(2, 11, 7, 15), 9).toList())
    println(twoSum2(intArrayOf(2, 11, 7, 15), 9).toList())
}

private fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        map[target - nums[i]]?.let { return intArrayOf(i, it) }
        map[nums[i]] = i
    }
    return intArrayOf()
}

private fun twoSum2(nums: IntArray, target: Int): IntArray {
    nums.forEachIndexed { fi, first ->
        nums.forEachIndexed { si, second ->
            if (first + second == target) return intArrayOf(fi, si)
        }
    }
    return intArrayOf()
}

