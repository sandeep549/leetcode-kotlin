package leetcode.kotlin.binarysearch

fun main() {
    println(searchRange(intArrayOf(1), 1).toList())
}

private fun searchRange(nums: IntArray, target: Int): IntArray {
    var lo = 0
    var hi: Int = nums.lastIndex
    var mid = 0
    while (lo < hi) { // find first
        mid = lo + (hi - lo) / 2
        if (nums[mid] < target) lo = mid + 1 else hi = mid
    }
    val first = lo
    // don't reset lo to 0
    hi = nums.lastIndex
    while (lo < hi) { // find last
        mid = lo + (hi - lo + 1) / 2 // keep mid towards hi side
        if (nums[mid] <= target) lo = mid else hi = mid - 1
    }
    return if (nums.isEmpty() || nums[lo] != target) intArrayOf(-1, -1) else intArrayOf(
        first,
        lo
    )
}
