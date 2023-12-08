package com.sk.set6

import com.sk.topicWise.tree.TreeNode

class Solution606 {
    fun tree2str(root: TreeNode?): String {
        return dfs(root).toString()
    }

    fun dfs(root: TreeNode?): StringBuilder {
        val sb = StringBuilder()
        if (root == null) return sb

        sb.append(root.`val`)
        if (root.left != null) sb.append("(${dfs(root.left)})")
        else if (root.right != null) sb.append("()")

        if (root.right != null) sb.append("(${dfs(root.right)})")

        return sb
    }

    fun tree2str2(t: TreeNode?): String {
        if (t == null) return ""
        val str = StringBuilder()
        traverse(t, str)
        return str.toString()
    }

    private fun traverse(node: TreeNode?, str: java.lang.StringBuilder) {
        // traverse curr node
        str.append(node!!.`val`)
        if (node.left == null && node.right == null) {
            return
        }

        // traverse left
        if (node.left != null) {
            str.append("(") // start left
            traverse(node.left, str)
            str.append(")") // close left
        }

        // traverse right
        if (node.right != null) {
            if (node.left == null) str.append("()")
            str.append("(") // start right
            traverse(node.right, str)
            str.append(")") // close right
        }
    }
}