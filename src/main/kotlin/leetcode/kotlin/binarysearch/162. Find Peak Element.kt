package leetcode.kotlin.binarysearch

fun main() {
    println(findPeakElement(intArrayOf(1, 2, 3, 1)))
    println(findPeakElement(intArrayOf(1, 2, 1, 3, 5, 6, 4)))
    println(findPeakElement(intArrayOf(1, 2)))
}

private fun findPeakElement2(arr: IntArray): Int {
    var l = 0
    var r = arr.lastIndex
    while (l < r) {
        val m = l + (r - l) / 2
        if (arr[m] < arr[m + 1]) l = m + 1
        else r = m
    }
    return l
}

private fun findPeakElement(nums: IntArray): Int {
    for (i in 0 until nums.lastIndex) {
        if (nums.get(i) > nums.get(i + 1)) return i
    }
    return nums.lastIndex
}
