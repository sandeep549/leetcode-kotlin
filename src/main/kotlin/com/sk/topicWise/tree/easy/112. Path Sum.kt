package com.sk.topicWise.tree.easy

import com.sk.topicWise.tree.TreeNode

class Solution112 {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) {
            return false
        }
        if (root.left == null && root.right == null && targetSum == root.`val`) {
            return true
        }

        return hasPathSum(root.left, targetSum - root.`val`) || hasPathSum(root.right, targetSum - root.`val`)
    }

    fun hasPathSum2(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) return false
        val queue = ArrayDeque<CustomNode>()
        queue.add(CustomNode(root, 0))
        while (!queue.isEmpty()) {
            val cn = queue.removeFirst()
            if (cn.node.left == cn.node.right && // both are null, leaf node
                cn.node.`val` + cn.sum == targetSum
            ) {
                return true
            }
            cn.node.left?.let {
                queue.add(CustomNode(it, cn.node.`val` + cn.sum))
            }
            cn.node.right?.let {
                queue.add(CustomNode(it, cn.node.`val` + cn.sum))
            }
        }
        return false
    }

    private class CustomNode(val node: TreeNode, val sum: Int)
}