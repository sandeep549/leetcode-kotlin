package com.sk

import java.util.Stack

private fun findUnsortedSubarray2(nums: IntArray): Int {
    var l = nums.size
    var r = 0
    for (i in 0 until nums.size - 1) {
        for (j in i + 1 until nums.size) {
            if (nums[j] < nums[i]) {
                r = maxOf(r, j)
                l = minOf(l, i)
            }
        }
    }
    return if (r - l < 0) 0 else r - l + 1
}

private fun findUnsortedSubarray3(nums: IntArray): Int {
    val copy = nums.clone()
    copy.sort()
    var start = copy.size
    var end = 0
    for (i in copy.indices) {
        if (copy[i] != nums[i]) {
            start = Math.min(start, i)
            end = Math.max(end, i)
        }
    }
    return if (end - start >= 0) end - start + 1 else 0
}

private fun findUnsortedSubarray4(nums: IntArray): Int {
    val stack = Stack<Int>()
    var l = nums.size
    var r = 0
    for (i in nums.indices) {
        while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
            l = minOf(l, stack.pop())
        }
        stack.push(i)
    }
    stack.clear()
    for (i in nums.indices.reversed()) {
        while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
            r = maxOf(r, stack.pop())
        }
        stack.push(i)
    }
    return if (r - l > 0) r - l + 1 else 0
}

private fun findUnsortedSubarray5(nums: IntArray): Int {
    var min = Int.MAX_VALUE
    var max = Int.MIN_VALUE
    var flag = false
    for (i in 1 until nums.size) {
        if (nums[i] < nums[i - 1]) flag = true
        if (flag) min = minOf(min, nums[i])
    }
    flag = false
    for (i in nums.size - 2 downTo 0) {
        if (nums[i] > nums[i + 1]) flag = true
        if (flag) max = maxOf(max, nums[i])
    }
    var l = 0
    while (l < nums.size) {
        if (min < nums[l]) break
        l++
    }
    var r = nums.size - 1
    while (r >= 0) {
        if (max > nums[r]) break
        r--
    }
    return if (r - l < 0) 0 else r - l + 1
}
