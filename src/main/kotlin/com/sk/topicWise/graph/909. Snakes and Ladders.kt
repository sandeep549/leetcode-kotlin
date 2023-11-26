package com.sk.topicWise.graph

class Solution909 {

    // https://leetcode.com/problems/snakes-and-ladders/solutions/173378/diagram-and-bfs/comments/1190493
    fun snakesAndLadders(board: Array<IntArray>): Int {
        val q = ArrayDeque<Int>()
        q.addLast(1)

        val n = board.size
        val target = n * n

        var steps = 0
        while (q.isNotEmpty()) {
            steps++
            var size = q.size
            while (size-- > 0) {
                val x = q.removeFirst()
                for (i in 1..6) {
                    var y = x + i
                    if (y > target) continue

                    val r = (y - 1) / n // expected row from top, -1 as cell no start from 1
                    val c = (y - 1) % n

                    // (n - 1 - r) is row from bottom,
                    // and colum from left or right side with even odd case
                    val v = board[n - 1 - r][if (r % 2 == 0) c else (n - 1 - c)]

                    if (v == 0) continue // already visited

                    if (v > 0) { // snake or ladder
                        y = v
                    }

                    if (y == target) return steps

                    q.addLast(y)
                    board[n - 1 - r][if (r % 2 == 0) c else n - 1 - c] = 0 // mark visited
                }
            }
        }

        return -1
    }
}