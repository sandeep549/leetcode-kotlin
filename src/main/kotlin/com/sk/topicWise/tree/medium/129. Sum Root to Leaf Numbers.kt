package com.sk.topicWise.tree.medium

import com.sk.topicWise.tree.TreeNode

class Solution129 {
    fun sumNumbers(root: TreeNode?): Int {
        return dfs(root, 0)
    }

    fun dfs(root: TreeNode?, n: Int): Int {
        if (root == null) {
            return 0
        }
        if (root.left == null && root.right == null) {
            val n = n * 10 + root.`val`
            return n
        }
        return dfs(root.left, n * 10 + root.`val`) +
                dfs(root.right, n * 10 + root.`val`)
    }
}