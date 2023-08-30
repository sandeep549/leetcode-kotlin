package com.sk.topicWise.tree.hard

class Solution2246 {

    private var longestPath = 0

    fun dfs(currentNode: Int, children: Map<Int, MutableList<Int>>, s: String): Int {
        if (!children.containsKey(currentNode)) {
            return 1
        }

        var longestChain = 0
        var secondLongestChain = 0
        for (child in children[currentNode]!!) {
            val longestChainStartingFromChild = dfs(child, children, s)
            if (s[currentNode] == s[child]) {
                continue
            }
            if (longestChainStartingFromChild > longestChain) {
                secondLongestChain = longestChain
                longestChain = longestChainStartingFromChild
            } else if (longestChainStartingFromChild > secondLongestChain) {
                secondLongestChain = longestChainStartingFromChild
            }
        }

        longestPath = maxOf(longestPath, longestChain + secondLongestChain + 1)
        return longestChain + 1
    }

    fun longestPath(parent: IntArray, s: String): Int {
        longestPath = 0
        val n = parent.size
        val children: MutableMap<Int, MutableList<Int>> = HashMap()
        // Start from node 1, since root node 0 does not have a parent.
        for (i in 1 until n) {
            val childList = children.getOrDefault(parent[i], mutableListOf())
            childList.add(i)
            children[parent[i]] = childList
        }
        dfs(0, children, s)
        return this.longestPath
    }
}
