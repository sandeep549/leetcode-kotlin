package com.sk.topicWise.binarysearch

class Solution33 {
    fun search(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) return -1

        // find smallest element, use it's index as rotation count
        var l = 0
        var r = nums.lastIndex
        while (l < r) {
            val mid = l + (r - l) / 2
            if (nums[mid] > nums[r]) l = mid + 1 // Why comparing with right element and not left ?
            else r = mid
        }

        val rot = l
        l = 0
        r = nums.lastIndex
        while (l < r) {
            val mid = l + (r - l) / 2
            val realmid = (mid + rot) % nums.size
            if (nums[realmid] < target) l = mid + 1
            else r = mid
        }
        l = (l + rot) % nums.size
        return if (nums[l] == target) l else -1
    }
}

// from solution
// https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/14435/Clever-idea-making-it-simple
private fun search2(nums: IntArray, target: Int): Int {
    if (nums.isEmpty()) return -1
    var l = 0
    var r = nums.lastIndex
    val MAX = Int.MAX_VALUE
    val MIN = Int.MIN_VALUE
    while (l < r) {
        val mid = l + (r - l) / 2
        val num = when {
            nums[mid] < nums[0] == target < nums[0] -> nums[mid]
            target < nums[0] -> MIN
            else -> MAX
        }
        if (num < target) l = mid + 1
        else r = mid
    }
    return if (nums[l] == target) l else -1
}
