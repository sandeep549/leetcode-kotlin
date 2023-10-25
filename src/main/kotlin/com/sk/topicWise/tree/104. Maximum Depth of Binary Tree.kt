package com.sk.topicWise.tree


class Solution104 {
    fun maxDepth(root: TreeNode?): Int {
        root?.let {
            return maxOf(maxDepth(it.left), maxDepth(it.right)) + 1
        }
        return 0
    }
}

// todo: do it iteratively
