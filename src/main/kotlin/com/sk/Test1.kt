package com.sk
// Google Interview Question

private data class Range(val label: String, val start: Int, val end: Int)
private data class MergedRange(val start: Int, val end: Int, val labels: List<String>)

private fun mergeAndLabelRanges(ranges: List<Range>): List<MergedRange> {
    // Create events for the sweep line algorithm
    val events = mutableListOf<Triple<Int, String, String>>() // (position, type, label)
    for (range in ranges) {
        events.add(Triple(range.start, "start", range.label))
        events.add(Triple(range.end, "end", range.label))
    }

    // Sort events by position, prioritizing "start" over "end" in case of ties
    events.sortWith(compareBy({ it.first }, { it.second == "end" }))

    val activeLabels = mutableSetOf<String>()
    val result = mutableListOf<MergedRange>()
    var prevPosition: Int? = null

    for ((position, type, label) in events) {
        if (prevPosition != null && position != prevPosition) {
            if (activeLabels.isNotEmpty()) {
                result.add(MergedRange(prevPosition, position, activeLabels.sorted()))
            }
        }

        when (type) {
            "start" -> activeLabels.add(label)
            "end" -> activeLabels.remove(label)
        }

        prevPosition = position
    }

    return result
}

// Example usage
//fun main() {
//    val ranges = listOf(
//        Range("A", 1, 5),
//        Range("B", 4, 9),
//        Range("C", 10, 15)
//    )
//
//    val output = mergeAndLabelRanges(ranges)
//    for (range in output) {
//        println("Range: [${range.start}, ${range.end}) => Labels: ${range.labels}")
//    }
//}

import java.util.PriorityQueue

fun dijkstra(graph: Map<String, List<Pair<String, Int>>>, source: String): Map<String, Int> {
    // Step 1: Initialize distances
    val distances = mutableMapOf<String, Int>().apply {
        graph.keys.forEach { this[it] = Int.MAX_VALUE }
        this[source] = 0
    }

    // Step 2: Priority queue to keep track of the minimum distance node
    val priorityQueue = PriorityQueue<Pair<String, Int>>(compareBy { it.second })
    priorityQueue.add(Pair(source, 0))

    // Step 3: Process nodes
    while (priorityQueue.isNotEmpty()) {
        val (currentNode, currentDistance) = priorityQueue.poll()

        // Skip if the current distance is not up-to-date
        if (currentDistance > distances[currentNode]!!) continue

        // Process neighbors
        for ((neighbor, weight) in graph[currentNode] ?: emptyList()) {
            val newDistance = currentDistance + weight

            // Update distance if a shorter path is found
            if (newDistance < distances[neighbor]!!) {
                distances[neighbor] = newDistance
                priorityQueue.add(Pair(neighbor, newDistance))
            }
        }
    }

    // Step 4: Return the shortest distances
    return distances
}