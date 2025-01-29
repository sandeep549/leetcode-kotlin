package com.sk.set9

class Solution994 {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val directions = arrayOf(
            intArrayOf(0, 1),  // right
            intArrayOf(1, 0),  // down
            intArrayOf(0, -1), // left
            intArrayOf(-1, 0)  // up
        )
        val rows = grid.size
        val cols = grid[0].size
        val queue: ArrayDeque<Pair<Int, Int>> = ArrayDeque()
        var freshOranges = 0

        // Initialize the queue with all rotten oranges and count fresh oranges
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (grid[i][j] == 2) {
                    queue.add(Pair(i, j))
                } else if (grid[i][j] == 1) {
                    freshOranges++
                }
            }
        }

        // If there are no fresh oranges, return 0
        if (freshOranges == 0) return 0

        var minutes = 0

        // BFS to spread the rotting effect
        while (queue.isNotEmpty()) {
            val size = queue.size
            var rottedThisMinute = false

            for (k in 0 until size) {
                val (x, y) = queue.removeFirst()

                for (dir in directions) {
                    val newX = x + dir[0]
                    val newY = y + dir[1]

                    // Check if the adjacent cell is a fresh orange
                    if (newX in 0 until rows && newY in 0 until cols && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2
                        freshOranges--
                        queue.add(Pair(newX, newY))
                        rottedThisMinute = true
                    }
                }
            }

            if (rottedThisMinute) minutes++
        }

        // If there are still fresh oranges left, return -1
        return if (freshOranges == 0) minutes else -1
    }

}
