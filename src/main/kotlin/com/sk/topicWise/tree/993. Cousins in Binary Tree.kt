package com.sk.topicWise.tree

import model.TreeNode

private fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
    var res = false
    fun dfs(root: TreeNode?): Int { // return depth of any target found first
        root?.let {
            if (it.`val` == x || it.`val` == y) return 1
            val l = dfs(it.left)
            val r = dfs(it.right)
            if (l > 1 && l == r) res = true // both at more than 1 depth and at same level
            return if (l == r) 0 else maxOf(l, r) + 1
        }
        return 0
    }
    dfs(root)
    return res
}

@ExperimentalStdlibApi
private fun isCousins2(root: TreeNode?, x: Int, y: Int): Boolean {
    if (root == null) return false
    class CustomNode(val node: TreeNode, val parent: Int)

    var firstMatchParent = -1
    val q = ArrayDeque<CustomNode>()
    q.add(CustomNode(root, -1))
    while (!q.isEmpty()) {
        var width = q.size
        while (width-- > 0) {
            val n = q.removeFirst()
            val newMatch = (n.node.`val` == x || n.node.`val` == y) // match found
            if (firstMatchParent != -1 && newMatch) return firstMatchParent != n.parent // Both match found
            if (newMatch && firstMatchParent == -1) firstMatchParent =
                n.parent // if first match found
            n.node.left?.let { q.add(CustomNode(it, n.node.`val`)) }
            n.node.right?.let { q.add(CustomNode(it, n.node.`val`)) }
        }
        if (firstMatchParent != -1) return false // only 1 match found in last level
    }
    return false
}
