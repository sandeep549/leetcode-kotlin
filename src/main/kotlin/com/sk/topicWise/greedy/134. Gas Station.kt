package com.sk.topicWise.greedy

class Solution134 {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        if (gas.sum() - cost.sum() < 0) return -1
        val n = gas.size
        for (i in gas.indices) { // Try with every start point
            var j = i
            var g = gas[i]
            while (true) {
                j %= n
                if (g < cost[j]) break // can not reach next station
                g -= cost[j] // Pay the gas
                j++ // Go to next station
                g += gas[j % n] // Take the gas from this station
                if (j % n == i) return i // reached start point?
            }
        }
        return -1
    }

    fun canCompleteCircuit2(gas: IntArray, cost: IntArray): Int {
        if (gas.sum() - cost.sum() < 0) return -1
        // find out where to start
        var tank = 0
        var start = 0
        for (i in gas.indices) {
            tank += gas[i] - cost[i]
            if (tank < 0) {
                start = i + 1
                tank = 0
            }
        }
        return start
    }
}

