package com.sk.topicWise.tree

import model.TreeNode

private fun minDiffInBST(root: TreeNode?): Int {
    var last: Int? = null
    var min = Int.MAX_VALUE
    fun dfs(root: TreeNode?) {
        root?.let {
            dfs(root.left)
            last?.let {
                min = min.coerceAtMost(root.`val` - last!!)
            }
            last = root.`val`
            dfs(root.right)
        }
    }
    dfs(root)
    return min
}

// TODO : try with iterative approach
