package com.sk.topicWise.hashtable

class Solution128 {
    fun longestConsecutive(nums: IntArray): Int {
        val set = nums.toSet()
        var streak = 0
        for(item in set) {
            if (!set.contains(item-1)) { // consider only bottom items
                var len = 1
                var num = item
                while (set.contains(num+1)) {
                    len++
                    num++
                }
                streak = maxOf(streak, len)
            }
        }
        return streak
    }

    fun longestConsecutive2(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        val arr = nums.sorted()
        var max = 1
        var len = 1
        for (i in 1..arr.lastIndex) {
            if (arr[i-1] == arr[i]) continue
            if (arr[i-1] + 1 == arr[i]) {
                len++
                max = maxOf(max, len)
            } else {
                len = 1
            }
        }
        return max
    }
}