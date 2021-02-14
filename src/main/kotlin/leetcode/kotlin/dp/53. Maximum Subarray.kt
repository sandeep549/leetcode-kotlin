package leetcode.kotlin.dp


/**
At any index 'n', maximum sum subarray  would be maximum of three
(1) Maximum found so far until last index i.e. f(n-1) ,
(2) Maximum found including last index plus current one,
(3) Only last index element arr[n].

1. Optimal structure
f(n) = MAX(f(n-1), f`(n-1) + arr[n], arr[n])
f`(i) = MAX(f`(i-1), 0) + arr[i]
Legends:
f(n) = max sum til n (excluding or including index n)
f`(n) = max sum which certainly includes index n
arr[n] = element at index n in given array

2. sub-problems calls tree for f(4), depicting overlapping sub-problems
f4
/   \
f3    f`3
/   \      \
f2    f`2    f`2
/  \      \      \
f1    f`1    f`1    f`1
/  \     \      \      \
f0   f`0   f`0    f`0    f`0

 */

// Top-down approach using memoization
// StackOverflowError for big size array, but works for smaller array size
private fun maxSubArray(arr: IntArray): Int {
    var dpi = IntArray(arr.size) { Int.MIN_VALUE }

    // Returns max sum ending at index i, which certainly include include index i
    fun maxi(i: Int): Int {
        if (i == 0) return arr[0]
        if (dpi[i] > Int.MIN_VALUE) return dpi[i]
        var r = maxOf(maxi(i - 1), 0) + arr[i]
        dpi[i] = r
        return r
    }

    fun max(n: Int): Int {
        if (n == 0) return arr[0]
        var r = maxOf(max(n - 1), maxi(n - 1) + arr[n])
        r = maxOf(r, arr[n])
        return r
    }
    return max(arr.size - 1)
}

// Bottom-up approach using tabulation
// f(n) = MAX(f(n-1), f`(n-1) + arr[n], arr[n])
// f(n) is maxSoFar
// f`(n) is maxEndingHere
private fun maxSubArray2(arr: IntArray): Int {
    var maxSoFar = arr[0]
    var maxEndingHere = arr[0]
    for (i in 1..arr.lastIndex) {
        maxEndingHere = maxOf(maxEndingHere + arr[i], arr[i])
        maxSoFar = maxOf(maxSoFar, maxEndingHere)
    }
    return maxSoFar
}
