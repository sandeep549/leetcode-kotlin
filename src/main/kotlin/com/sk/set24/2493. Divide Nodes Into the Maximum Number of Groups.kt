package com.sk.set24

import java.util.*

class Solution {
    fun maxNumberOfGroups(n: Int, edges: Array<IntArray>): Int {
        val graph = mutableMapOf<Int, MutableList<Int>>()

        // Step 1: Build adjacency list
        for ((a, b) in edges) {
            graph.computeIfAbsent(a) { mutableListOf() }.add(b)
            graph.computeIfAbsent(b) { mutableListOf() }.add(a)
        }

        val visited = mutableSetOf<Int>()
        var maxGroups = 1  // Stores the maximum depth found across components

        // BFS function to find longest shortest path (diameter)
        fun bfs(start: Int): Int {
            val queue: Queue<Int> = LinkedList()
            val dist = mutableMapOf<Int, Int>()
            queue.add(start)
            dist[start] = 0
            visited.add(start)

            var farthestNode = start
            while (queue.isNotEmpty()) {
                val node = queue.poll()
                for (neighbor in graph.getOrDefault(node, emptyList())) {
                    if (neighbor !in dist) {
                        dist[neighbor] = dist[node]!! + 1
                        queue.add(neighbor)
                        if (dist[neighbor]!! > dist[farthestNode]!!) {
                            farthestNode = neighbor
                        }
                    }
                }
            }
            return farthestNode
        }

        // Finding the diameter of each connected component
        for (node in 1..n) {
            if (node !in visited) {
                val farthest1 = bfs(node)  // Find a farthest node
                val farthest2 = bfs(farthest1)  // Find longest path from that node
                maxGroups = maxOf(maxGroups, farthest2)
            }
        }

        return maxGroups + 1  // Since the depth gives us (groups - 1)
    }
}