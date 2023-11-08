package com.sk.topicWise.tree.medium

import com.sk.topicWise.tree.TreeNode
import java.util.*


class Solution114 {
    fun flatten(root: TreeNode?) {
        if (root == null) return
        val l = root.left
        val r = root.right
        root.left = null
        flatten(l)
        flatten(r)
        root.right = l
        var cur = root
        while (cur!!.right != null) {
            cur = cur.right
        }
        cur.right = r
    }

    fun flatten2(root: TreeNode?) {
        if (root == null) return
        val stk = Stack<TreeNode?>()
        stk.push(root)
        while (!stk.isEmpty()) {
            val curr = stk.pop()
            if (curr!!.right != null) stk.push(curr.right)
            if (curr.left != null) stk.push(curr.left)
            if (!stk.isEmpty()) curr.right = stk.peek()
            curr.left = null // dont forget this!!
        }
    }

    private var prev: TreeNode? = null

    fun flatten3(root: TreeNode?) {
        if (root == null) return
        flatten3(root.right)
        flatten3(root.left)
        root.right = prev
        root.left = null
        prev = root
    }

    fun flatten4(root: TreeNode?) {
        var root = root
        while (root != null) {
            if (root.left != null) {
                var prev = root.left
                while (prev!!.right != null) {
                    prev = prev.right
                }
                prev.right = root.right
                root.right = root.left
                root.left = null
            }
            root = root.right
        }
    }
}