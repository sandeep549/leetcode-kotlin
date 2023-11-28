package com.sk.set4

import java.util.Stack

private fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
    val map = mutableMapOf<Int, Int>()
    val stack = Stack<Int>()
    for (num in nums2) {
        while (!stack.isEmpty() && stack.peek() < num) {
            map[stack.pop()] = num
        }
        stack.push(num)
    }
    for (i in nums1.indices) {
        nums1[i] = map.getOrDefault(nums1[i], -1)
    }
    return nums1
}