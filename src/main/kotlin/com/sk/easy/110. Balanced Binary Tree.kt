package com.sk.easy

import com.sk.topicWise.tree.TreeNode

class Solution110 {
    fun isBalanced(root: TreeNode?): Boolean {
        return dfs(root).first
    }

    fun dfs(root: TreeNode?): Pair<Boolean, Int> {
        if (root == null) return Pair(true, 0)
        val l = dfs(root.left)
        val r = dfs(root.right)
        val d = maxOf(l.second, r.second) + 1
        return if (l.first && r.first && (l.second - r.second) in -1..1) {
            Pair(true, d)
        } else {
            Pair(false, d)
        }
    }

    //todo: iterative
}