package topicWise.tree.medium

class Solution1443 {
    fun minTime(n: Int, edges: Array<IntArray>, hasApple: List<Boolean>): Int {
        val graph = Array<MutableList<Int>>(n) { mutableListOf() }

        // build adjacency list
        for (edge in edges) {
            graph[edge[0]].add(edge[1])
            graph[edge[1]].add(edge[0])
        }
        val visited = BooleanArray(n)
        visited[0] = true
        return dfs(graph, 0, hasApple, visited)
    }

    // dfs on adjacency list
    private fun dfs(graph: Array<MutableList<Int>>, curr: Int, hasApple: List<Boolean>, visited: BooleanArray): Int {
        var res = 0
        for (next in graph[curr]) {
            if (visited[next]) continue
            visited[next] = true
            res += dfs(graph, next, hasApple, visited)
        }
        if ((res > 0 || hasApple[curr]) && curr != 0) {
            res += 2
        }
        return res
    }
}
