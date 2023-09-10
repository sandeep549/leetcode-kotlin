package com.sk.topicWise.tree

private fun binaryTreePaths(root: TreeNode?): List<String> {
    val res = mutableListOf<String>()
    fun dfs(root: TreeNode?, path: StringBuilder) {
        root?.let {
            if (it.left == it.right) {
                res.add(path.append(it.`val`).toString())
            } else {
                val newPath = StringBuilder().append(path).append(it.`val`).append("->")
                dfs(it.left, StringBuilder(newPath))
                dfs(it.right, StringBuilder(newPath))
            }
        }
    }
    dfs(root, StringBuilder())
    return res
}

// TODO: do it with iteration
// TODO: calculate exact time complexity
