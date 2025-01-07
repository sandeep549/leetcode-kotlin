package com.sk.set10

class Solution1094 {
    fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
        // Find the maximum location to determine the size of the changes array
        var maxLocation = 0
        for (trip in trips) {
            maxLocation = maxOf(maxLocation, trip[1], trip[2])  // Consider both pickup and drop-off locations
        }

        // Initialize an array to track changes in passengers at each location
        val changes = IntArray(maxLocation + 1)

        // For each trip, mark the start and end locations with passenger changes
        for (trip in trips) {
            val (numPassengers, start, end) = trip
            changes[start] += numPassengers  // Passengers get in at start location
            changes[end] -= numPassengers    // Passengers get off at end location (exclusive)
        }

        // Now, iterate through the changes array to calculate the cumulative number of passengers
        var currentPassengers = 0
        for (passengerChange in changes) {
            currentPassengers += passengerChange
            if (currentPassengers > capacity) {
                return false
            }
        }

        // If we never exceeded the capacity, return true
        return true
    }
}