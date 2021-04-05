package leetcode.kotlin.tree

private fun sumNumbers(root: TreeNode?): Int {
    var result = 0
    if (root == null) return result
    fun dfs(root: TreeNode, no: Int) {
        val newNo = no * 10 + (root.`val` ?: 0)
        if (root.left == null && root.right == null) {
            result += newNo
            return
        }
        root.left?.let { dfs(it, newNo) }
        root.right?.let { dfs(it, newNo) }
    }
    dfs(root, 0)
    return result
}