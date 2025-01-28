package com.sk.set10

import java.util.PriorityQueue

class Solution {
    fun twoCitySchedCost(costs: Array<IntArray>): Int {
        // Sort by the difference between cost of City A and City B
        costs.sortBy { it[0] - it[1] }

        var totalCost = 0
        val n = costs.size / 2

        // First half goes to City A, second half goes to City B
        for (i in costs.indices) {
            if (i < n) {
                totalCost += costs[i][0] // Send to City A
            } else {
                totalCost += costs[i][1] // Send to City B
            }
        }

        return totalCost
    }
}