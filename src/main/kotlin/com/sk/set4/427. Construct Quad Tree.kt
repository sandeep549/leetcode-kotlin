package com.sk.set4

class Solution427 {
    fun construct(grid: Array<IntArray>): Node {
        return helper(grid, 0, 0, grid.size)
    }

    private fun helper(grid: Array<IntArray>, x: Int, y: Int, len: Int): Node {
        if (len == 1) {
            return Node(grid[x][y] != 0, true)
        }
        val result = Node(false, false)
        val topLeft = helper(grid, x, y, len / 2)
        val topRight = helper(grid, x, y + len / 2, len / 2)
        val bottomLeft = helper(grid, x + len / 2, y, len / 2)
        val bottomRight = helper(grid, x + len / 2, y + len / 2, len / 2)

        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf && topLeft.`val` == topRight.`val` && topRight.`val` == bottomLeft.`val` && bottomLeft.`val` == bottomRight.`val`) {
            result.isLeaf = true
            result.`val` = topLeft.`val`
        } else {
            result.topLeft = topLeft
            result.topRight = topRight
            result.bottomLeft = bottomLeft
            result.bottomRight = bottomRight
        }

        return result
    }

    class Node(var `val`: Boolean, var isLeaf: Boolean) {
        var topLeft: Node? = null
        var topRight: Node? = null
        var bottomLeft: Node? = null
        var bottomRight: Node? = null
    }
}