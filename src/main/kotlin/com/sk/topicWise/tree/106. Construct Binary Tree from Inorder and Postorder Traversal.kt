package com.sk.topicWise.tree

import model.TreeNode

private fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
    var i = postorder.lastIndex // track root in post-order
    fun dfs(l: Int, r: Int): TreeNode? {
        if (l > r) return null
        if (l == r) {
            return TreeNode(postorder[i--])
        }
        var k = l
        while (k <= r) {
            if (inorder[k] == postorder[i]) break
            k++
        }
        val root = TreeNode(inorder[k])
        i--
        root.right = dfs(k + 1, r)
        root.left = dfs(l, k - 1)
        return root
    }
    return dfs(0, inorder.lastIndex)
}
