package com.sk.set1

class Solution {
    internal fun cloneGraph(node: Node?): Node? {
        return dfs(node, HashMap())
    }

    internal fun dfs(node: Node?, seen: HashMap<Node, Node>): Node? {
        if (node == null) return null
        if (seen.contains(node)) return seen[node]

        val new = Node(node.`val`)
        val neighbors = ArrayList<Node?>()
        new.neighbors = neighbors
        seen[node] = new

        node.neighbors?.forEach {
            dfs(it, seen)?.let { neighbors.add(it) }
        }

        return new
    }
}


internal class Node(val `val`: Int) {
    var neighbors: ArrayList<Node?>? = null
}