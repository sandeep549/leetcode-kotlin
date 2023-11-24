package com.sk.medium

class Solution399 {
    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
        val map = HashMap<String, Node>()
        for (i in equations.indices) {
            val eq = equations[i]
            val first = eq[0]
            val second = eq[1]
            if (map.containsKey(first).not()) {
                val node = Node()
                node.values = ArrayList()
                node.neighbours = ArrayList()
                map[first] = node
            }
            if (map.containsKey(second).not()) {
                val node = Node()
                node.values = ArrayList()
                node.neighbours = ArrayList()
                map[second] = node
            }
            val node1 = map[first]
            val node2 = map[second]

            node1?.neighbours?.add(node2)
            node1?.values?.add(values[i])

            node2?.neighbours?.add(node1)
            node2?.values?.add(1/values[i])
        }

        val res = DoubleArray(queries.size) { -1.0 }
        for (i in queries.indices) {
            val query = queries[i]
            val first = query[0]
            val second = query[1]
            val node1 = map[first] ?: continue
            val node2 = map[second] ?: continue
            var ans = 1
            val seen = HashSet<Node>()
            res[i] = dfs(node1, 1.0, node2, seen)
        }

        return res
    }

    private fun dfs(node: Node?, value: Double, target: Node, seen: HashSet<Node>): Double {
        if (node == null || seen.contains(node)) return -1.0
        if (node == target) {
            return value
        }
        seen.add(node)
        for (i in node.neighbours?.indices!!) {
            val neighbour = node.neighbours!![i]
            val v = node.values?.get(i)
            dfs(neighbour, value * v!!, target, seen).let {
                if (it != -1.0) return it
            }
        }
        return -1.0
    }

    class Node {
        var values: ArrayList<Double>? = null
        var neighbours: ArrayList<Node?>? = null
    }
}