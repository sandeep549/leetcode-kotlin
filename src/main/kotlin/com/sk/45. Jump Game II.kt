package com.sk

import kotlin.math.min

// https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/

class Solution45 {

    fun jump(nums: IntArray): Int {
        val table = IntArray(nums.size) { Int.MAX_VALUE }
        table[0] = 0
        // find min jumps to reach at every index i
        for (i in 1..nums.lastIndex) {
            for (j in 0 until i) {
                if (j + nums[j] >= i) {
                    table[i] = minOf(table[i], table[j] + 1)
                }
            }
        }
        return table.last()
    }

    /**
     * This is an implicit bfs solution. i == curEnd means you visited all the items on the current level.
     * Incrementing jumps++ is like incrementing the level you are on. And curEnd = curFarthest is like getting
     * the queue size (level size) for the next level you are traversing.
     */
    fun jump3(nums: IntArray): Int {
        var jumps = 0
        var curEnd = 0
        var curFarthest = 0
        for (i in 0 until nums.lastIndex) {
            curFarthest = maxOf(curFarthest, i + nums[i])
            if (i == curEnd) {
                jumps++
                curEnd = curFarthest
            }
        }
        return jumps
    }
}


private class RecursiveSolution {
    fun jump(nums: IntArray): Int {
        return minJumps(0, nums.lastIndex, nums)
    }

    private fun minJumps(l: Int, h: Int, arr: IntArray): Int {
        if (h == l) return 0

        if (arr[l] == 0) return Int.MAX_VALUE

        var min = Int.MAX_VALUE
        var i = l + 1
        while (i <= h && i <= l + arr[l]) {
            val jumps: Int = minJumps(i, h, arr)
            if (jumps != Int.MAX_VALUE && jumps + 1 < min) {
                min = jumps + 1
            }
            i++
        }
        return min
    }
}

