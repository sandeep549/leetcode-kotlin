package com.sk.topicWise.tree

import model.TreeNode
import kotlin.math.max

private fun maxDepth(root: TreeNode?): Int {
    root?.let {
        return max(maxDepth(it.left), maxDepth(it.right)) + 1
    }
    return 0
}

// todo: do it iteratively
