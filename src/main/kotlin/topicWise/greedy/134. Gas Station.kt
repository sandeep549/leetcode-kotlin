package topicWise.greedy

private fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
    var start = 0
    while (start < gas.size) {
        var i = start
        var cur_gas = gas[start]
        while (i < start + gas.size) {
            i %= gas.size
            if (cur_gas < cost[i]) break
            cur_gas = cur_gas - cost[i] + gas[(++i) % gas.size]
            if (i % gas.size == start) return start
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
