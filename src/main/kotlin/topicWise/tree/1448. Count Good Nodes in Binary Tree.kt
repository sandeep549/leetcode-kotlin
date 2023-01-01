package topicWise.tree

private fun goodNodes(root: TreeNode?): Int {
    val list = dfs(root)
    return list.size
}

fun dfs(root: TreeNode?): List<Int> {
    if (root == null) return emptyList()
    val l = dfs(root.left)
    val r = dfs(root.right)
    val list = mutableListOf(root.`val`)
    val items = (l + r + list).filter { it >= root.`val` }
    return items
}
