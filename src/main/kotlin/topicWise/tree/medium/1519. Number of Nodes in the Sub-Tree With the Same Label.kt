package topicWise.tree.medium

class Solution {
    fun countSubTrees(n: Int, edges: Array<IntArray>, labels: String): IntArray {

        // make adjacency list
        val graph = Array<MutableList<Int>>(n) { mutableListOf() }
        for(edge in edges) {
            graph[edge[0]].add(edge[1])
            graph[edge[1]].add(edge[0])
        }

        val visited = BooleanArray(n)
        visited[0] = true
        val result = IntArray(n)
        dfs(n, graph, 0, labels, visited, result)[0]
        return result
    }

    /*
     When backtracking, keep track of 2 things.
     (1) From every node return frequency of all lowercase letter found from left and right, add current one also
     (2) Update all same label found so far for this node under it.
    */
    fun dfs(n: Int, graph: Array<MutableList<Int>>, cur: Int,
            labels: String, visited: BooleanArray,
            result: IntArray): IntArray {

        val childFreq = IntArray(26)
        for(next in graph[cur]) {
            if(visited[next]) continue
            visited[next] = true
            val arr = dfs(n, graph, next, labels, visited, result)
            for(i in arr.indices) {
                childFreq[i] += arr[i]
            }
        }
        childFreq[labels[cur]-'a']++

        result[cur] = childFreq[labels[cur] - 'a']

        return childFreq
    }
}
