package com.sk.topicWise.dp

class Solution746 {
    fun minCostClimbingStairs(cost: IntArray): Int {
        var pre = cost[1]
        var prepre = cost[0]
        for (i in 2..cost.lastIndex) {
            var here = minOf(pre + cost[i], prepre + cost[i])
            prepre = pre
            pre = here
        }
        return minOf(pre, prepre)
    }
}
