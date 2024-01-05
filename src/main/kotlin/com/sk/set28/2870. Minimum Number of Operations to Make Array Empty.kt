package com.sk.set28

class Solution {
    fun minOperations(nums: IntArray): Int {
        val frequency = nums.groupBy { it }.mapValues { it.value.size }
        var ans = 0
        for (entry in frequency) {
            if (entry.value % 3 == 0) {
                ans += entry.value/3
            } else if(entry.value > 2 && (entry.value-2) % 3 == 0) {
                ans += (entry.value-2)/3
                ans++
            } else if(entry.value > 4 && (entry.value-4) % 3 == 0) {
                ans += (entry.value-4)/3
                ans+=2
            } else if(entry.value % 2 == 0) {
                ans += entry.value/2
            } else {
                return -1
            }
        }
        return ans
    }
}