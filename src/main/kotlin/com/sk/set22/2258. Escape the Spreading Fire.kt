package com.sk.set22

class Solution2258 {
    fun maximumMinutes(grid: Array<IntArray>): Int {
        val directions = arrayOf(
            intArrayOf(0, 1), intArrayOf(1, 0),
            intArrayOf(0, -1), intArrayOf(-1, 0)
        )
        val m = grid.size
        val n = grid[0].size

        // Step 1: Calculate fire spread times
        val fireTime = Array(m) { IntArray(n) { Int.MAX_VALUE } }
        val fireQueue = ArrayDeque<Pair<Int, Int>>()
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 1) {
                    fireQueue.add(Pair(i, j))
                    fireTime[i][j] = 0
                }
            }
        }

        while (fireQueue.isNotEmpty()) {
            val (x, y) = fireQueue.removeFirst()
            for (dir in directions) {
                val nx = x + dir[0]
                val ny = y + dir[1]
                if (nx in 0 until m && ny in 0 until n && grid[nx][ny] == 0 && fireTime[nx][ny] == Int.MAX_VALUE) {
                    fireTime[nx][ny] = fireTime[x][y] + 1
                    fireQueue.add(Pair(nx, ny))
                }
            }
        }

        // Step 2: Binary search for the maximum waiting time
        fun canReachSafehouse(waitTime: Int): Boolean {
            if (waitTime >= fireTime[0][0]) return false
            val visited = Array(m) { BooleanArray(n) }
            val queue = ArrayDeque<Triple<Int, Int, Int>>()
            queue.add(Triple(0, 0, waitTime))
            visited[0][0] = true

            while (queue.isNotEmpty()) {
                val (x, y, time) = queue.removeFirst()
                for (dir in directions) {
                    val nx = x + dir[0]
                    val ny = y + dir[1]
                    val nextTime = time + 1
                    if (nx in 0 until m && ny in 0 until n && grid[nx][ny] == 0 && !visited[nx][ny]) {
                        // Check if we can move to the next cell safely
                        if (nextTime < fireTime[nx][ny] || (nx == m - 1 && ny == n - 1 && nextTime <= fireTime[nx][ny])) {
                            if (nx == m - 1 && ny == n - 1) return true
                            visited[nx][ny] = true
                            queue.add(Triple(nx, ny, nextTime))
                        }
                    }
                }
            }
            return false
        }

        var left = 0
        var right = 1000000000
        var result = -1

        while (left <= right) {
            val mid = left + (right - left) / 2
            if (canReachSafehouse(mid)) {
                result = mid
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return result
    }


}