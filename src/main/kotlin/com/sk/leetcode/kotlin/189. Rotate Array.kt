package com.sk.leetcode.kotlin

class Solution189 {

    // time-O(n*k); n is size of array
    fun rotate(nums: IntArray, k: Int) {
        var count = k % nums.size
        repeat(count) {
            val last = nums.last()
            for (j in nums.lastIndex downTo 1) {
                nums[j] = nums[j - 1]
            }
            nums[0] = last
        }
    }

    // time-O(n), space-O(n); n is size of array
    fun rotate2(nums: IntArray, k: Int) {
        val arr = IntArray(nums.size)
        for (i in nums.indices) {
            arr[(i + k) % nums.size] = nums[i]
        }
        for (i in arr.indices) {
            nums[i] = arr[i]
        }
    }

    fun rotate3(nums: IntArray, k: Int) {
        if (k == 0) return
        val rotation = k % nums.size
        var swap = 0
        var startIdx = 0
        while (startIdx < nums.size) {
            var currIdx = startIdx
            var prev = nums[startIdx]
            do {
                val nextIdx = (currIdx + rotation) % nums.size
                val temp = nums[nextIdx]
                nums[nextIdx] = prev
                prev = temp
                currIdx = nextIdx
                swap++
                if (swap == nums.size) return
            } while (startIdx != currIdx)
            startIdx++
        }
    }

    // time-O(n), space-O(1); n is size of array
    fun rotate4(nums: IntArray, k: Int) {
        val rotation = k % nums.size
        reverseInRange(nums, 0, nums.size - 1)
        reverseInRange(nums, 0, rotation - 1)
        reverseInRange(nums, rotation, nums.size - 1)
    }

    fun reverseInRange(nums: IntArray, start: Int, end: Int) {
        var l = start
        var r = end
        while (l < r) {
            nums[l] = nums[r].also { nums[r] = nums[l] }
            l++
            r--
        }
    }

}




