package com.sk.set32

import java.util.*

class Solution3243 {
    fun shortestDistanceAfterQueries(n: Int, queries: Array<IntArray>): IntArray {
        val roads = MutableList(n) { mutableListOf<Int>() }
        val dp = IntArray(n) { it } // Shortest distance to reach here
        val result = mutableListOf<Int>()

        for (query in queries) {
            val (source, destination) = query
            roads[destination].add(source)

            for (i in destination until n) {
                dp[i] = minOf(dp[i], dp[i - 1] + 1) // Update using adjacent node
                for (start in roads[i]) {
                    dp[i] = minOf(dp[i], dp[start] + 1) // Update using previous road connections
                }
            }

            result.add(dp[n - 1])
        }

        return result.toIntArray()
    }

    fun shortestDistanceAfterQueries2(n: Int, queries: Array<IntArray>): IntArray {
        // Adjacency list representation of the graph
        val graph = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
        for (i in 0 until n - 1) {
            graph.computeIfAbsent(i) { mutableListOf() }.add(Pair(i + 1, 1)) // Initial roads, weight = 1
        }

        // Dijkstra's algorithm to find shortest path from 0 to n-1
        fun dijkstra(): Int {
            val dist = IntArray(n) { Int.MAX_VALUE }
            dist[0] = 0
            val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.first }) // (distance, node)
            pq.add(Pair(0, 0))

            while (pq.isNotEmpty()) {
                val (currentDist, node) = pq.poll()
                if (currentDist > dist[node]) continue
                graph[node]?.forEach { (neighbor, weight) ->
                    if (dist[node] + weight < dist[neighbor]) {
                        dist[neighbor] = dist[node] + weight
                        pq.add(Pair(dist[neighbor], neighbor))
                    }
                }
            }
            return dist[n - 1]
        }

        val answer = mutableListOf<Int>()
        for (query in queries) {
            val (u, v) = query
            graph.computeIfAbsent(u) { mutableListOf() }.add(Pair(v, 1)) // Add new edge with weight = 1
            answer.add(dijkstra())
        }

        return answer.toIntArray()
    }
}


