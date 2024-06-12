package com.sk.set0

// https://en.wikipedia.org/wiki/Dutch_national_flag_problem

class Solution75 {

    fun sortColors(nums: IntArray) {
        var i = 0 // track first index of 1 from start, where we want to put next 0
        var j = 0 // track current index
        var k = nums.size - 1 // track first index of 2 from end where we want to put next 2
        while (j <= k) {
            when (nums[j]) {
                0 -> { // j has red
                    nums[i] = nums[j].also { nums[j] = nums[i] }
                    i++
                    j++
                }

                1 -> { // j has white
                    j++
                }

                else -> { // j has blue
                    nums[j] = nums[k].also { nums[k] = nums[j] }
                    k--
                }
            }
        }
    }
}
