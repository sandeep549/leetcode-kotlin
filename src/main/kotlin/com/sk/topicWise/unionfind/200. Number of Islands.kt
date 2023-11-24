package com.sk.topicWise.unionfind

import java.util.*


class Solution200 {

    fun numIslands(grid: Array<CharArray>): Int {
        val seen = HashSet<Pair<Int, Int>>()
        var count = 0
        for (r in grid.indices) {
            for (c in grid[0].indices) {
                if (dfs(grid, r, c, seen)) count++
            }
        }
        return count
    }

    fun dfs(grid: Array<CharArray>, r: Int, c: Int, seen: HashSet<Pair<Int, Int>>): Boolean {
        if (r < 0 || r >= grid.size || c < 0 || c >= grid[0].size) return false
        if (grid[r][c] == '0' || seen.contains(Pair(r, c))) return false
        seen.add(Pair(r, c))
        dfs(grid, r, c + 1, seen)
        dfs(grid, r, c - 1, seen)
        dfs(grid, r - 1, c, seen)
        dfs(grid, r + 1, c, seen)
        return true
    }


    var distance = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
    fun numIslands2(grid: Array<CharArray>): Int {
        if (grid.isEmpty()) return 0
        val uf = UnionFind(grid)
        val rows = grid.size
        val cols = grid[0].size
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (grid[i][j] == '1') {
                    for (d in distance) {
                        val x = i + d[0]
                        val y = j + d[1]
                        if (x in 0..<rows && y >= 0 && y < cols && grid[x][y] == '1') {
                            val id1 = i * cols + j
                            val id2 = x * cols + y
                            uf.union(id1, id2)
                        }
                    }
                }
            }
        }
        return uf.count
    }
}


private class UnionFind(grid: Array<CharArray>) {
    var parent: IntArray
    var m: Int
    var n: Int
    var count = 0

    init {
        m = grid.size
        n = grid[0].size
        parent = IntArray(m * n)
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == '1') {
                    val id = i * n + j
                    parent[id] = id
                    count++
                }
            }
        }
    }

    fun union(node1: Int, node2: Int) {
        val find1 = find(node1)
        val find2 = find(node2)
        if (find1 != find2) {
            parent[find1] = find2
            count--
        }
    }

    fun find(node: Int): Int {
        if (parent[node] == node) {
            return node
        }
        parent[node] = find(parent[node])
        return parent[node]
    }

}


class Solution200_1 {
    lateinit var parent: IntArray
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty()) return 0
        val n = grid.size
        val m = grid[0].size
        parent = IntArray(m * n)
        Arrays.fill(parent, -1)
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (grid[i][j] == '1') {
                    parent[i * m + j] = i * m + j // note, that `parent` was filled witn -1 values
                    if (i > 0 && grid[i - 1][j] == '1') union(i * m + j, (i - 1) * m + j) // union current+top
                    if (j > 0 && grid[i][j - 1] == '1') union(i * m + j, i * m + (j - 1)) // union current+left
                }
            }
        }
        val set = HashSet<Int>()
        for (k in parent.indices) {
            if (parent[k] != -1) set.add(find(k))
        }
        return set.size
    }

    fun find(x: Int): Int {
        if (parent[x] == x) return x
        parent[x] = find(parent[x])
        return parent[x]
    }

    fun union(x: Int, y: Int) {
        val px = find(x)
        val py = find(y)
        parent[px] = parent[py]
    }
}
