package com.sk.set2

class Solution217 {
    fun containsDuplicate(nums: IntArray): Boolean {
        val seen = HashSet<Int>()
        return nums.any { !seen.add(it) }
    }
}