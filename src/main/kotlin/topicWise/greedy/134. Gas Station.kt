package topicWise.greedy

private fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
    var start = 0
    while (start < gas.size) { // Try with every start point
        var i = start
        var g = gas[start]
        while (true) {
            i %= gas.size
            if (g < cost[i]) break // can not reach next station
            g -= cost[i] // Pay the gas
            i++ // Go to next station
            g += gas[i % gas.size] // Take the gas from this station
            if (i % gas.size == start) return start // reached start point?
        }
        start++
    }
    return -1
}

private fun canCompleteCircuit2(gas: IntArray, cost: IntArray): Int {
    //determine if we have a solution
    var total = 0
    for (i in gas.indices) {
        total += gas[i] - cost[i]
    }
    if (total < 0) {
        return -1
    }

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
