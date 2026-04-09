package com.sk

class Solution {
    fun pivotArray(nums: IntArray, pivot: Int): IntArray {
        val result = IntArray(nums.size)
        var i = 0
        var j = 0
        while (j < nums.size) {
            if (nums[j] < pivot) {
                result[i] = nums[j]
                i++
            }
            j++
        }

        j = 0
        while (j < nums.size) {
            if (nums[j] == pivot) {
                result[i] = nums[j]
                i++
            }
            j++
        }

        j = 0
        while (j < nums.size) {
            if (nums[j] > pivot) {
                result[i] = nums[j]
                i++
            }
            j++
        }

        return result
    }

    fun pivotArray2(nums: IntArray, pivot: Int): IntArray {
        val less = mutableListOf<Int>()
        val equal = mutableListOf<Int>()
        val greater = mutableListOf<Int>()

        for (num in nums) {
            when {
                num < pivot -> less.add(num)
                num == pivot -> equal.add(num)
                else -> greater.add(num)
            }
        }

        return (less + equal + greater).toIntArray()
    }
}