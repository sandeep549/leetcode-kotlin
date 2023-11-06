package com.sk.topicWise.tree.bst

import com.sk.topicWise.tree.TreeNode

class Solution98 {
    fun isValidBST(root: TreeNode?): Boolean {
        return dfs(root, null, null)
    }

    private fun dfs(root: TreeNode?, l: Int?, r: Int?): Boolean {
        if (root == null) return true
        val res = dfs(root.left, l, root.`val`)
        if (!res) return false
        if (l != null && root.`val` <= l) return false
        if (r != null && root.`val` >= r) return false
        return dfs(root.right, root.`val`, r)
    }

    fun isValidBST2(root: TreeNode?): Boolean {
        val stack = ArrayDeque<TreeNode>()
        var inorder: Int? = null
        var curr = root
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.addLast(curr)
                curr = curr.left
            }
            curr = stack.removeLast()
            // If next element in inorder traversal
            // is smaller(or equal) than the previous one
            // that's not BST.
            if (inorder != null && curr.`val` <= inorder) return false
            inorder = curr.`val`
            curr = curr.right
        }
        return true
    }
}

