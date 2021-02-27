package leetcode.kotlin.unionfind

private fun numIslands(grid: Array<CharArray>): Int {
    val seen = mutableSetOf<Pair<Int, Int>>()
    fun dfs(r: Int, c: Int): Boolean {
        if (r < 0 || r >= grid.size || c < 0 || c >= grid[0].size) return false
        if (grid[r][c] == '0' || seen.contains(Pair(r, c))) return false
        seen.add(Pair(r, c))
        dfs(r, c + 1)
        dfs(r, c - 1)
        dfs(r - 1, c)
        dfs(r + 1, c)
        return true
    }

    var count = 0
    for (r in grid.indices) {
        for (c in grid[0].indices) {
            if (dfs(r, c)) count++
        }
    }
    return count
}

private fun numIslands2(grid: Array<CharArray>): Int {
    fun dfs(r: Int, c: Int) {
        if (r < 0 || r >= grid.size || c < 0 || c >= grid[0].size) return
        if (grid[r][c] == '0') return
        grid[r][c] = '0'
        dfs(r, c + 1)
        dfs(r, c - 1)
        dfs(r - 1, c)
        dfs(r + 1, c)
    }

    var count = 0
    for (r in grid.indices) {
        for (c in grid[0].indices) {
            if (grid[r][c] == '1') {
                count++
                dfs(r, c)
            }
        }
    }
    return count
}

private fun numIslands3(grid: Array<CharArray>): Int {
    val islands = mutableListOf<MutableSet<Pair<Int, Int>>>()
    fun find(r: Int, c: Int, island: MutableSet<Pair<Int, Int>>) {
        if (r < 0 || r >= grid.size || c < 0 || c >= grid[0].size) return // invalid index
        if (grid[r][c] == '0') return // not land
        val land = Pair(r, c)
        if (island.contains(land)) return // land part of current island under consideration
        if (islands.any { it.contains(land) }) return // land part of other islands

        island.add(land) // add this land to current island

        // search further
        find(r, c + 1, island)
        find(r, c - 1, island)
        find(r - 1, c, island)
        find(r + 1, c, island)
    }

    for (r in grid.indices) {
        for (c in grid[0].indices) {
            val island = mutableSetOf<Pair<Int, Int>>()
            find(r, c, island)
            if (island.isNotEmpty()) islands.add(island)
        }
    }
    return islands.size
}

// todo: do it with bfs and union find
// https://leetcode.com/problems/number-of-islands/solution/
