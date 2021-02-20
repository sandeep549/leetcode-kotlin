package leetcode.kotlin.tree

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
    if (root.left == null && root.right == null && targetSum - root.`val` == 0) return true
    return hasPathSum2(root.left, targetSum - root.`val`) || hasPathSum2(
        root.right,
        targetSum - root.`val`
    )
}
