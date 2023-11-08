package com.sk.topicWise.tree.medium

import com.sk.topicWise.tree.TreeNode

class Solution106 {
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        return dfs(inorder, postorder, postorder.lastIndex, 0, inorder.lastIndex)
    }

    private fun dfs(inorder: IntArray, postorder: IntArray, i: Int, l: Int, r: Int): TreeNode? {
        if (i < 0 || l > r) return null
        val root = postorder[i]
        var k = r
        while (k >= l) {
            if (inorder[k] == root) break
            k--
        }
        val node = TreeNode(root)
        node.right = dfs(inorder, postorder, i-1, k + 1, r)
        node.left = dfs(inorder, postorder, i - (r - k + 1), l, k - 1)
        return node
    }
}

