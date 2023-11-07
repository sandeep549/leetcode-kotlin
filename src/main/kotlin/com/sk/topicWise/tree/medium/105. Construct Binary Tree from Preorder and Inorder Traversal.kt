package com.sk.topicWise.tree.medium

import com.sk.topicWise.tree.TreeNode
import com.sun.source.tree.Tree

class Solution105 {

    /**
     * 1. traverse in preorder from left to right and pick one element e1.
     * 2. find this element e1's location in inorder, divide inorder in two parts being e1 as pivot.
     * 3. Make e1 as root, recur in left sub-part of inorder for left subtree and right part of inorder for right subtree.
     */

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        return dfs(preorder, inorder, 0, 0, inorder.size)
    }

    private fun dfs(preorder: IntArray, inorder: IntArray, i: Int, l: Int, r: Int): TreeNode? {
        if (i >= preorder.size || l > r) return null
        val root = preorder[i]
        var k = l
        while (k < r) {
            if (inorder[k] == root) break
            k++
        }
        val node = TreeNode(root)
        node.left = dfs(preorder, inorder, i + 1, l, k - 1)
        node.right = dfs(preorder, inorder, i + k - l + 1, k + 1, r)
        return node
    }
}

