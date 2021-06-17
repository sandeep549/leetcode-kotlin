package leetcode.kotlin.dp

/**
 * f(n) - Maximum sum ending at index n
 * maxSoFar - Max sum found so far
 * Relation:
 * f(n) = MAX(f(n-1) + arr[n], arr[n]])
 * For every iteration update maxSoFar found, and at last return it.
 */

// Top-down approach using memoization
// StackOverflowError for big size array, but works for smaller array size

private class Solution {
    var maxSoFar = 0
    fun maxSubArray(arr: IntArray): Int {
        maxSoFar = arr[arr.lastIndex]
        maxEndingAt(arr.lastIndex, arr)
        return maxSoFar
    }

    private fun maxEndingAt(n: Int, arr: IntArray): Int {
        if (n < 0) return 0
        val maxHere = maxOf(maxEndingAt(n - 1, arr) + arr[n], arr[n])
        maxSoFar = maxOf(maxSoFar, maxHere)
        return maxHere
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
