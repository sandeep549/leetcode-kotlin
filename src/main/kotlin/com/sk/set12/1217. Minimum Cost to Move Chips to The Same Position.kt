package com.sk.set12

class Solution1217 {
    fun minCostToMoveChips(position: IntArray): Int {
        var evenCount = 0
        var oddCount = 0

        // Count chips at even and odd positions
        for (pos in position) {
            if (pos % 2 == 0) {
                evenCount++
            } else {
                oddCount++
            }
        }

        // The cost is the minimum of moving chips to all even or all odd positions
        return minOf(evenCount, oddCount)
    }
}