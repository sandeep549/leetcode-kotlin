package com.sk.topicWise.hashtable

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
