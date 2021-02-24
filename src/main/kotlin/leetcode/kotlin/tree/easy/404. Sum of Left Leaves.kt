package leetcode.kotlin.tree.easy

import leetcode.kotlin.tree.TreeNode

private fun sumOfLeftLeaves(root: TreeNode?): Int {
    var sum = 0
    fun dfs(node: TreeNode?, isLeft: Boolean) {
        node?.let {
            if (it.left == it.right && isLeft) sum += it.`val`
            dfs(it.left, true)
            dfs(it.right, false)
        }
    }
    dfs(root, false)
    return sum
}

@ExperimentalStdlibApi
private fun sumOfLeftLeaves2(root: TreeNode?): Int {
    if (root == null) return 0
    var sum = 0
    val q = ArrayDeque<TreeNode>()
    q.add(root)
    while (!q.isEmpty()) {
        val node = q.removeFirst()
        if (node.left != null && node.left!!.left == node.left!!.right) {
            sum += node.left!!.`val`
            node.right?.let { q.add(it) }
        } else {
            node.left?.let { q.add(it) }
            node.right?.let { q.add(it) }
        }
    }
    return sum
}
