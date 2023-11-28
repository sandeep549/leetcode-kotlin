package com.sk.set0

// https://en.wikipedia.org/wiki/Dutch_national_flag_problem

private fun sortColors(nums: IntArray) {
    var i = 0 // track first index index of 1 from start
    var j = 0 // track current index
    var k = nums.lastIndex // track first index of 2 from end
    while (j <= k) {
        if (nums[j] == 0) {
            nums[i] = nums[j].also { nums[j] = nums[i] } // swap i and j
            i++
        }
        if (nums[j] == 2) {
            nums[k] = nums[j].also { nums[j] = nums[k] }
            k--
            j--
        }
        j++
    }
}

private fun sortColors2(nums: IntArray) {
    // 1-pass
    var p1 = 0
    var p2 = nums.size - 1
    var index = 0
    while (index <= p2) {
        if (nums[index] == 0) {
            nums[index] = nums[p1]
            nums[p1] = 0
            p1++
        }
        if (nums[index] == 2) {
            nums[index] = nums[p2]
            nums[p2] = 2
            p2--
            index--
        }
        index++
    }
}
