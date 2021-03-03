package leetcode.kotlin.tree

@ExperimentalStdlibApi
private fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
    val res = mutableListOf<MutableList<Int>>()
    if (root == null) return res
    var lToR = true
    var stack = ArrayDeque<TreeNode>()
    stack.add(root)
    while (!stack.isEmpty()) {
        var size = stack.size
        val level = mutableListOf<Int>()
        val newStack = ArrayDeque<TreeNode>()
        while (size-- > 0) {
            val node = stack.removeLast()
            level.add(node.`val`)
            if (lToR) {
                node.left?.let { newStack.add(it) }
                node.right?.let { newStack.add(it) }
            } else {
                node.right?.let { newStack.add(it) }
                node.left?.let { newStack.add(it) }
            }
        }
        res.add(level)
        lToR = !lToR
        stack = newStack
    }
    return res
}
