package com.sk.set17

class Solution1713 {
    fun minOperations(target: IntArray, arr: IntArray): Int {
        val dp = Array(target.size) { IntArray(arr.size) { -1 } }
        return target.size - match(0, 0, 0, target, arr, dp)
    }

    private fun match(i: Int, j: Int, l: Int, target: IntArray, arr: IntArray, dp: Array<IntArray>): Int {
        if (i >= target.size || j >= arr.size) return l
        if (dp[i][j] != -1) return dp[i][j]
        val v1 = match(i + 1, j, l, target, arr, dp) // we skipped ith element
        var v2 = 0
        for (k in j..arr.lastIndex) { // we considered ith element
            if (target[i] == arr[k]) {
                v2 = maxOf(v2, match(i + 1, k + 1, l + 1, target, arr, dp))
            }
        }
        dp[i][j] = maxOf(v1, v2)
        return dp[i][j]
    }

    fun minOperations2(target: IntArray, arr: IntArray): Int {
        val valueToIndexMap = target.mapIndexed { index, i -> i to index }.toMap()

        val list = mutableListOf<Int>()
        for (n in arr) {
            val index = valueToIndexMap[n]
            if (index != null) {
                if (list.isEmpty() || list.last() < index) {
                    list.add(index)
                } else {
                    val i = list.binarySearch(index).let { if (it < 0) -it - 1 else it }
                    list[i] = index
                }
            }
        }
        return target.size - list.size
    }
}