package com.sk.set4

import java.util.*

class Solution407 {
    fun trapRainWater(heightMap: Array<IntArray>): Int {
        if (heightMap.isEmpty() || heightMap[0].isEmpty()) return 0

        val rows = heightMap.size
        val cols = heightMap[0].size
        val visited = Array(rows) { BooleanArray(cols) }
        val heap = PriorityQueue<Cell>(compareBy { it.height })

        // Add all boundary cells to the heap
        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (r == 0 || r == rows - 1 || c == 0 || c == cols - 1) {
                    heap.add(Cell(r, c, heightMap[r][c]))
                    visited[r][c] = true
                }
            }
        }

        val directions = arrayOf(
            intArrayOf(0, 1), intArrayOf(1, 0),
            intArrayOf(0, -1), intArrayOf(-1, 0)
        )

        var water = 0
        while (heap.isNotEmpty()) {
            val cell = heap.poll()

            for (dir in directions) {
                val newRow = cell.row + dir[0]
                val newCol = cell.col + dir[1]

                if (newRow in 0 until rows && newCol in 0 until cols && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true
                    val newHeight = heightMap[newRow][newCol]
                    water += maxOf(0, cell.height - newHeight)
                    heap.add(Cell(newRow, newCol, maxOf(cell.height, newHeight)))
                }
            }
        }

        return water
    }

    data class Cell(val row: Int, val col: Int, val height: Int)
}