package leetcode.kotlin.array.medium

import java.util.Stack

private fun dailyTemperatures(temperatures: IntArray): IntArray {
    val result = IntArray(temperatures.size)
    val stack = Stack<Int>() // Make it a stack of indices.
    for (i in temperatures.indices) {
        while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
            val index = stack.pop()
            result[index] = i - index
        }
        stack.push(i)
    }
    return result
}