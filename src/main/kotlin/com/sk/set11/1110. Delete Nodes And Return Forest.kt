package com.sk.set11

import com.sk.topicWise.tree.TreeNode

class Solution {
    var toDeleteSet = mutableSetOf<Int>()
    var newRoots = mutableListOf<TreeNode>()
    fun delNodes(root: TreeNode?, to_delete: IntArray): List<TreeNode> {
        toDeleteSet = to_delete.toHashSet()
        newRoots = mutableListOf()
        helper(root, true)
        return newRoots
    }

    // If a node is root (has no parent) and isn't deleted, add to the result.
    private fun helper(node: TreeNode?, noParent: Boolean): TreeNode? {
        if (node == null) return null
        val deleted = toDeleteSet.contains(node.`val`)
        if (noParent && !deleted) newRoots.add(node)
        node.left = helper(node.left, deleted)
        node.right = helper(node.right, deleted)
        return if (deleted) null else node
    }
}