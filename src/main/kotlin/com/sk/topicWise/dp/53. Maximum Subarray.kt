package com.sk.topicWise.dp

/**
 * At any index i there are 3 possibilities,
 * (1) Max sub-array is found before i.e. maxSoFar
 * (2) Max sub-array is running and also include this element i.e. maxEndingHere
 * (3) Max sub-array start here and may contains only this element
 */

// Top-down approach using memoization
// StackOverflowError for big size array, but works for smaller array size

private class Solution {
    fun maxSubArray(arr: IntArray): Int {
        return maxEndingAt(arr.lastIndex, arr).second
    }

    private fun maxEndingAt(n: Int, arr: IntArray): Pair<Int, Int> {
        if (n == 0) return Pair(arr[0], arr[0])
        val mx = maxEndingAt(n - 1, arr)
        val maxHere = maxOf(mx.first + arr[n], arr[n])
        val maxSoFar = maxOf(mx.second, maxHere)
        return Pair(maxHere, maxSoFar)
    }
}

// Bottom-up approach using tabulation
private fun maxSubArray2(arr: IntArray): Int {
    var maxSoFar = arr[0]
    var maxEndingHere = arr[0]
    for (i in 1..arr.lastIndex) {
        maxEndingHere = maxOf(maxEndingHere + arr[i], arr[i])
        maxSoFar = maxOf(maxSoFar, maxEndingHere)
    }
    return maxSoFar
}
