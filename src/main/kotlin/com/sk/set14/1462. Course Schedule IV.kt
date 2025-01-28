package com.sk.set14

class Solution1462 {
    fun checkIfPrerequisite(numCourses: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): List<Boolean> {
        // Create a reachability matrix
        val reachable = Array(numCourses) { BooleanArray(numCourses) }

        // Mark direct prerequisites
        for ((a, b) in prerequisites) {
            reachable[a][b] = true
        }

        // Floyd-Warshall algorithm to compute transitive closure
        for (k in 0 until numCourses) {
            for (i in 0 until numCourses) {
                for (j in 0 until numCourses) {
                    if (reachable[i][k] && reachable[k][j]) {
                        reachable[i][j] = true
                    }
                }
            }
        }

        // Answer the queries
        return queries.map { (u, v) -> reachable[u][v] }
    }
}