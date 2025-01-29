package com.sk.set6

class Solution684 {
    class UnionFind(n: Int) {
        private val parent = IntArray(n + 1) { it }
        private val rank = IntArray(n + 1) { 1 }

        fun find(x: Int): Int {
            if (parent[x] != x) {
                parent[x] = find(parent[x]) // Path compression
            }
            return parent[x]
        }

        fun union(x: Int, y: Int): Boolean {
            val rootX = find(x)
            val rootY = find(y)

            if (rootX == rootY) return false // Cycle detected

            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY
            } else {
                parent[rootY] = rootX
                rank[rootX]++
            }
            return true
        }
    }

    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val uf = UnionFind(edges.size)

        for (edge in edges) {
            if (!uf.union(edge[0], edge[1])) {
                return edge // Edge forming a cycle
            }
        }

        return intArrayOf()
    }
}