package com.sk.topicWise.tree.bst

import com.sk.topicWise.tree.TreeNode

class Solution530 {
    fun getMinimumDifference(root: TreeNode?): Int {
        var min = Int.MAX_VALUE
        val stack = ArrayDeque<TreeNode>()
        var cur = root
        var pre: TreeNode? = null
        while (cur != null || stack.isNotEmpty()) {
            if (cur != null) {
                stack.addLast(cur)
                cur = cur.left
            } else {
                cur = stack.removeLast()
                if (pre != null) {
                    min = minOf(min, cur.`val` - pre.`val`)
                }
                pre = cur
                cur = cur.right
            }
        }
        return min
    }
}