package com.sk.topicWise.twopointer

class Solution80 {
    fun removeDuplicates(nums: IntArray): Int {
        var i = 0
        var j = 0
        var count = 1
        while(i < nums.size) {
            if(j == 0 || nums[j-1] == nums[i]) {
                if(count < 2) {
                    nums[j] = nums[i]
                    count++
                    j++
                }
            } else {
                nums[j] = nums[i]
                count = 1
                j++
            }
            i++
        }
        return j
    }

    fun removeDuplicates2(nums: IntArray): Int {
        var i = 0
        for (n in nums) {
            if (i < 2 || n > nums[i - 2]) {
                nums[i] = n
                i++
            }
        }
        return i
    }
}