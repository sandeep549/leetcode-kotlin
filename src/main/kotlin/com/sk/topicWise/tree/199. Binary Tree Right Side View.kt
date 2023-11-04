package com.sk.topicWise.tree

class Solution199 {
    fun rightSideView(root: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()
        dfs(root, 0, list)
        return list
    }

    private fun dfs(root: TreeNode?, level: Int, list: MutableList<Int>) {
        if (root == null) return
        if (level == list.size) list.add(root.`val`)
        dfs(root.right, level + 1, list)
        dfs(root.left, level + 1, list)
    }

    fun rightSideView2(root: TreeNode?): List<Int> { // reverse level traversal
        val result = mutableListOf<Int>()
        if (root == null) return result
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val cur = queue.removeFirst()
                if (i == 0) result.add(cur.`val`)
                cur.right?.let { queue.add(it) }
                cur.left?.let { queue.add(it) }
            }
        }
        return result
    }

}

