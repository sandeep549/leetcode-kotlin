package com.sk.set8

class Solution802 {
    // Topological Sort Using Kahn's Algorithm
    fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        val n = graph.size
        val reverseGraph = Array<MutableList<Int>>(n) { mutableListOf() }
        val outDegrees = IntArray(n) // Track the out-degrees of each node

        // Build the reverse graph and calculate out-degrees
        for (node in graph.indices) {
            for (neighbor in graph[node]) {
                reverseGraph[neighbor].add(node) // Reverse the edge
            }
            outDegrees[node] = graph[node].size
        }

        // Queue for nodes with 0 out-degree
        val queue = ArrayDeque<Int>()
        for (i in outDegrees.indices) {
            if (outDegrees[i] == 0) queue.add(i)
        }

        val safeNodes = mutableListOf<Int>()

        // Process the queue
        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            safeNodes.add(current) // Add the node to the safe list

            for (neighbor in reverseGraph[current]) {
                outDegrees[neighbor]-- // Reduce the out-degree of neighbors
                if (outDegrees[neighbor] == 0) {
                    queue.add(neighbor) // Add to queue if it becomes safe
                }
            }
        }

        // Sort the result since nodes must be returned in sorted order
        return safeNodes.sorted()
    }

    // Topological Sort Using Kahn's Algorithm
    fun eventualSafeNodes2(graph: Array<IntArray>): List<Int> {
        return emptyArray<Int>().toList()
    }
}