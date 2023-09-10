package com.sk.topicWise.tree

private fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    var ans = false
    fun dfs(node: TreeNode, sum: Int) {
        val curSum = sum + node.`val`
        if (node.left == null && node.right == null) {
            if (curSum == targetSum) ans = true
            return
        }
        node.left?.let { dfs(it, curSum) }
        node.right?.let { dfs(it, curSum) }
    }
    root?.let {
        dfs(it, 0)
    }
    return ans
}

private fun hasPathSum2(root: TreeNode?, targetSum: Int): Boolean {
    if (root == null) return false
    if (root.left == root.right) return targetSum == root.`val`
    return hasPathSum2(root.left, targetSum - root.`val`) ||
        hasPathSum2(root.right, targetSum - root.`val`)
}

@ExperimentalStdlibApi
private fun hasPathSum3(root: TreeNode?, targetSum: Int): Boolean {
    class CustomNode(val node: TreeNode, val sum: Int)
    if (root == null) return false
    val queue = ArrayDeque<CustomNode>()
    queue.add(CustomNode(root, 0))
    while (!queue.isEmpty()) {
        val cn = queue.removeFirst()
        if (cn.node.left == cn.node.right &&
            cn.node.`val` + cn.sum == targetSum
        ) return true
        cn.node.left?.let {
            queue.add(CustomNode(it, cn.node.`val` + cn.sum))
        }
        cn.node.right?.let {
            queue.add(CustomNode(it, cn.node.`val` + cn.sum))
        }
    }
    return false
}
