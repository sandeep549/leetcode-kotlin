package com.sk.topicWise.tree.easy

import com.sk.topicWise.tree.TreeNode


class Solution222 {
    fun countNodes(root: TreeNode?): Int {
        if (root == null) return 0
        val h = height(root)
        if (height(root.right) == h - 1) { // left subtree is full tree of height h-1
            return (1 shl h - 1) + countNodes(root.right)
        } else {
            return (1 shl h - 2) + countNodes(root.left)
        }
    }

    private fun height(root: TreeNode?): Int {
        var h = 0
        var node = root
        while (node != null) {
            node = node.left
            h++
        }
        return h
    }
}