package com.sk.set18

class Solution1814 {
    fun countNicePairs(nums: IntArray): Int {
        val arr = nums.map { it - rev(it) }
        val freqMap = mutableMapOf<Int, Int>()
        var nice = 0
        val MOD = (1e9 + 7).toInt()

        for (item in arr) {
            val count = freqMap.getOrDefault(item, 0)
            nice = (nice + count) % MOD
            freqMap[item] = (count + 1) % MOD
        }
        return nice
    }

    private fun rev(num: Int): Int {
        var res = 0
        var input = num
        while (input != 0) {
            val r = input % 10
            res *= 10
            res += r
            input /= 10
        }
        return res
    }
}