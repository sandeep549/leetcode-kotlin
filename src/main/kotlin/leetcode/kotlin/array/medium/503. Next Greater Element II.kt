package leetcode.kotlin.array.medium

import java.util.Stack

private fun nextGreaterElements(nums: IntArray): IntArray {
    val n = nums.size
    val result = IntArray(n) { -1 }
    val stack = Stack<Int>()
    var i = 0
    while (i < 2 * n) {
        while (stack.isNotEmpty() && nums[i % n] > nums[stack.peek()]) {
            result[stack.peek()] = nums[i % n]
            stack.pop()
        }
        stack.push(i % n)
        i++
    }
    return result
}

private fun nextGreaterElements2(nums: IntArray): IntArray {
    val n = nums.size
    val result = IntArray(n) { -1 }
    val stack = Stack<Int>()
    var i = 0
    var scan = 1
    while (i < n) {
        while (stack.isNotEmpty() && nums[i] > nums[stack.peek()]) {
            result[stack.peek()] = nums[i]
            stack.pop()
        }
        stack.push(i)
        i++
        if (i == n && stack.size <= 1) break
        else if (i == n && scan == 1) {
            i = 0
            scan++
        } else if (stack.size == 2 && scan == 2) break
    }
    return result
}