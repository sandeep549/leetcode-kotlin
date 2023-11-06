package com.sk.topicWise.tree

class Solution230 {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        return dfs(root, k, 0)[1]
    }

    private fun dfs(root: TreeNode?, k: Int, count: Int): IntArray { // (count-done,element)
        if(root == null) return intArrayOf(count, 0)
        val c = dfs(root.left, k, count)
        return if(c[0] < k) {
            if(c[0] + 1 == k) {
                intArrayOf(k, root.`val`)
            } else {
                dfs(root.right, k, c[0]+1)
            }
        } else {
            c
        }
    }

    fun kthSmallest2(root: TreeNode?, k: Int): Int {
        val stack = ArrayDeque<TreeNode>()
        var node = root
        var count = 0
        while (true) {
            while (node != null) {
                stack.addLast(node)
                node = node.left
            }
            node = stack.removeLast()
            if (++count == k) {
                return node.`val`
            }
            node = node.right
        }
    }
}


