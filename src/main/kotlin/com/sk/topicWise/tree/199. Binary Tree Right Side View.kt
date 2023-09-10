package com.sk.topicWise.tree

private fun rightSideView(root: TreeNode?): List<Int> {
    val list = mutableListOf<Pair<Int, Int>>()
    val set = mutableSetOf<Int>()
    fun dfs(root: TreeNode?, level: Int) {
        root?.let {
            dfs(root.right, level + 1)
            if (!set.contains(level)) {
                list.add(Pair(level, root.`val`))
                set.add(level)
            }
            dfs(root.left, level + 1)
        }
    }
    dfs(root, 0)
    list.sortBy { it.first }
    return list.map { it.second }
}

private fun rightSideView2(root: TreeNode?): List<Int> {
    val list = mutableListOf<Int>()
    fun dfs(root: TreeNode?, level: Int) {
        root?.let {
            if (list.size < level) list.add(root.`val`)
            dfs(root.right, level + 1)
            dfs(root.left, level + 1)
        }
    }
    dfs(root, 1)
    return list
}

/*
 Right to left level traversal
 */
private fun rightSideView3(root: TreeNode?): List<Int> { // reverse level traversal
    val result = mutableListOf<Int>()
    val queue = ArrayDeque<TreeNode>()
    if (root == null) return result
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
