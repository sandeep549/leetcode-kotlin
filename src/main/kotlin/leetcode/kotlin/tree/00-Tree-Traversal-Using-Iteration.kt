package leetcode.kotlin.tree

/*
    Tree traversal using iterations.
 */

@ExperimentalStdlibApi
private fun inorder(root: TreeNode?) {
    val stack = ArrayDeque<TreeNode>()
    var node = root
    node?.let { stack.addLast(it) }
    while (stack.isNotEmpty()) {
        while (node != null) {
            stack.addLast(node)
            node = node.left
        }
        node = stack.removeLast()
        print(node.`val`)
        node = node.right
    }
}
