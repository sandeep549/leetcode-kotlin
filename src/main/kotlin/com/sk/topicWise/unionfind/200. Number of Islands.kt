package com.sk.topicWise.unionfind

val seen = mutableSetOf<Pair<Int, Int>>()
private fun numIslands(grid: Array<CharArray>): Int {
    var count = 0
    for (r in grid.indices) {
        for (c in grid[0].indices) {
            if (dfs(grid, r, c)) count++
        }
    }
    return count
}

fun dfs(grid: Array<CharArray>, r: Int, c: Int): Boolean {
    if (r < 0 || r >= grid.size || c < 0 || c >= grid[0].size) return false
    if (grid[r][c] == '0' || seen.contains(Pair(r, c))) return false
    seen.add(Pair(r, c))
    dfs(grid, r, c + 1)
    dfs(grid, r, c - 1)
    dfs(grid, r - 1, c)
    dfs(grid, r + 1, c)
    return true
}


val islands = mutableListOf<MutableSet<Pair<Int, Int>>>()
private fun numIslands3(grid: Array<CharArray>): Int {
    for (r in grid.indices) {
        for (c in grid[0].indices) {
            val island = mutableSetOf<Pair<Int, Int>>()
            find(grid, r, c, island)
            if (island.isNotEmpty()) islands.add(island)
        }
    }
    return islands.size
}

fun find(grid: Array<CharArray>, r: Int, c: Int, island: MutableSet<Pair<Int, Int>>) {
    if (r < 0 || r >= grid.size || c < 0 || c >= grid[0].size) return // invalid index
    if (grid[r][c] == '0') return // not land
    val land = Pair(r, c)
    if (island.contains(land)) return // land part of current island under consideration
    if (islands.any { it.contains(land) }) return // land part of other islands

    island.add(land) // add this land to current island

    // search further
    find(grid, r, c + 1, island)
    find(grid, r, c - 1, island)
    find(grid, r - 1, c, island)
    find(grid, r + 1, c, island)
}

// todo: do it with bfs and union find
// https://leetcode.com/problems/number-of-islands/solution/
