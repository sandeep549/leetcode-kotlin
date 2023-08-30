package com.sk.topicWise.tree

import model.TreeNode

private fun isValidBST2(root: TreeNode?): Boolean {
    fun dfs(node: TreeNode?, l: Int?, r: Int?): Boolean {
        node ?: return true
        l?.let { if (node.`val` <= it) return false }
        r?.let { if (node.`val` >= it) return false }
        return dfs(node.left, l, node.`val`) && dfs(node.right, node.`val`, r)
    }
    return dfs(root, null, null)
}

@ExperimentalStdlibApi
private fun isValidBST3(root: TreeNode?): Boolean {
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
        // is smaller than the previous one
        // that's not BST.
        if (inorder != null && curr.`val` <= inorder) return false
        inorder = curr.`val`
        curr = curr.right
    }
    return true
}
