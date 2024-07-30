package com.sk.set16

import kotlin.math.min


class Solution1653 {
    fun minimumDeletions(s: String): Int {
        val n = s.length
        var aCount = s.count { it == 'a' }

        var bCount = 0
        var minDeletions = n

        s.forEach { ch ->
            if (ch == 'a') aCount--
            minDeletions = minOf(minDeletions, aCount + bCount)
            if (ch == 'b') bCount++
        }

        return minDeletions
    }

    fun minimumDeletions2(s: String): Int {
        val n = s.length
        var minDeletions = 0
        var bCount = 0

        // minDeletions variable represents dp[i]
        s.forEach { ch ->
            if (ch == 'b') {
                bCount++
            } else {
                minDeletions = minOf(minDeletions + 1 /* Delete a */,  bCount /* Delete b */)
            }
        }

        return minDeletions
    }
}