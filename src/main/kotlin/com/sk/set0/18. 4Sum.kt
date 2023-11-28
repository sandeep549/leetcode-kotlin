package com.sk.set0

import java.util.ArrayList
import java.util.Arrays

private class Solution {
    var len = 0
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        len = nums.size
        Arrays.sort(nums)
        return kSum(nums, target, 4, 0)
    }

    private fun kSum(
        nums: IntArray,
        target: Int,
        k: Int,
        index: Int
    ): MutableList<MutableList<Int>> {
        val res = mutableListOf<MutableList<Int>>()
        if (index >= len) {
            return res
        }
        if (k == 2) {
            var i = index
            var j = len - 1
            while (i < j) {
                //find a pair
                if (target - nums[i] == nums[j]) {
                    val temp: MutableList<Int> = ArrayList()
                    temp.add(nums[i])
                    temp.add(target - nums[i])
                    res.add(temp)
                    //skip duplication
                    while (i < j && nums[i] == nums[i + 1]) i++
                    while (i < j && nums[j - 1] == nums[j]) j--
                    i++
                    j--
                    //move left bound
                } else if (target - nums[i] > nums[j]) {
                    i++
                    //move right bound
                } else {
                    j--
                }
            }
        } else {
            var i = index
            while (i < len - k + 1) {

                //use current number to reduce ksum into k-1sum
                val temp = kSum(nums, target - nums[i], k - 1, i + 1)
                if (temp != null) {
                    //add previous results
                    for (t in temp) {
                        t.add(0, nums[i])
                    }
                    res.addAll(temp)
                }
                while (i < len - 1 && nums[i] == nums[i + 1]) {
                    //skip duplicated numbers
                    i++
                }
                i++
            }
        }
        return res
    }
}