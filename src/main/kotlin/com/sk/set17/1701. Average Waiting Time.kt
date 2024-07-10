package com.sk.set17

class Solution2385 {
    fun averageWaitingTime(customers: Array<IntArray>): Double {
        val waitingTimeList = mutableListOf<Int>()
        var currentTime = 1
        customers.forEach { (arrival, preparationTime) ->
            if (currentTime <= arrival) {
                waitingTimeList.add(preparationTime)
                currentTime = arrival + preparationTime
            } else {
                var waiting = currentTime - arrival
                waiting += preparationTime
                currentTime += preparationTime
            }
        }
        return waitingTimeList.average()
    }
}