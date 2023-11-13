package com.sk.topicWise.tree.easy

import com.sk.topicWise.tree.TreeNode

class Solution617 {
    fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
        if (root1 == null && root2 == null) return null
        val node = TreeNode((root1?.`val` ?: 0) + (root2?.`val` ?: 0))
        node.left = mergeTrees(root1?.left, root2?.left)
        node.right = mergeTrees(root1?.right, root2?.right)
        return node
    }
}