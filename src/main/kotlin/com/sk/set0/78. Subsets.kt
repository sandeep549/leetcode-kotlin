package com.sk.set0

import kotlin.math.pow


class Solution78 {

    // Backtracking
    fun subsets(nums: IntArray): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        fun backtrack(tmpList: MutableList<Int>, start: Int) {
            ans.add(tmpList.toList()) // copy it and add it to answer
            for (i in start..nums.lastIndex) {
                tmpList.add(nums[i])
                backtrack(tmpList, i + 1)
                tmpList.removeAt(tmpList.lastIndex)
            }
        }
        backtrack(mutableListOf(), 0)
        return ans
    }

    // Iterative
    fun subsets2(nums: IntArray): List<List<Int>> {
        val result: MutableList<List<Int>> = ArrayList()
        result.add(ArrayList())
        for (n in nums) {
            val size = result.size
            for (i in 0 until size) {
                val subset: MutableList<Int> = ArrayList(result[i])
                subset.add(n)
                result.add(subset)
            }
        }
        return result
    }

    // bit manipulation
    fun subsets3(nums: IntArray): List<List<Int>> {
        val output = mutableListOf<MutableList<Int>>()
        val n = nums.size
        for (i in 2.0.pow(n).toInt() until 2.0.pow(n + 1).toInt()) { // generate bitmask, from 0..00 to 1..11
            val bitmask = Integer.toBinaryString(i).substring(1)
            // append subset corresponding to that bitmask
            val curr = mutableListOf<Int>()
            for (j in 0 until n) {
                if (bitmask[j] == '1') curr.add(nums[j])
            }
            output.add(curr)
        }
        return output
    }

}

