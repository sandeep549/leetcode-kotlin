package com.sk.set13

class Solution1368 {
    fun minCost(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        // Directions: right, left, down, up
        val directions = listOf(Pair(0, 1), Pair(0, -1), Pair(1, 0), Pair(-1, 0))

        val deque = ArrayDeque<Triple<Int, Int, Int>>() // (x, y, cost)
        val dist = Array(m) { IntArray(n) { Int.MAX_VALUE } }
        dist[0][0] = 0
        deque.addFirst(Triple(0, 0, 0))

        while (deque.isNotEmpty()) {
            val (x, y, cost) = deque.removeFirst()

            // If we already have a smaller cost for this cell, skip it
            if (cost > dist[x][y]) continue

            // Check all 4 directions
            for ((d, direction) in directions.withIndex()) {
                val nx = x + direction.first
                val ny = y + direction.second

                if (nx in 0 until m && ny in 0 until n) {
                    // Calculate the new cost
                    val newCost = if (grid[x][y] == d + 1) cost else cost + 1

                    // Update the cost if it's better
                    if (newCost < dist[nx][ny]) {
                        dist[nx][ny] = newCost
                        if (grid[x][y] == d + 1) {
                            deque.addFirst(Triple(nx, ny, newCost)) // No cost
                        } else {
                            deque.addLast(Triple(nx, ny, newCost)) // Cost 1
                        }
                    }
                }
            }
        }

        return dist[m - 1][n - 1]
    }
}