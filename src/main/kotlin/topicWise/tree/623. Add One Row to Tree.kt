package topicWise.tree

@ExperimentalStdlibApi
fun addOneRow(root: TreeNode?, v: Int, d: Int): TreeNode? {
    if (d == 1) {
        val tmp = TreeNode(v)
        tmp.left = root
        return tmp
    }
    val q = ArrayDeque<TreeNode>()
    root?.let { q.add(it) }
    var level = 1
    while (q.isNotEmpty()) {
        var size = q.size
        while (size-- > 0) {
            val node = q.removeFirst()
            if (level == d - 1) {
                var tmp = node.left
                node.left = TreeNode(v)
                node.left!!.left = tmp
                tmp = node.right
                node.right = TreeNode(v)
                node.right!!.right = tmp
            }
            node.left?.let { q.add(it) }
            node.right?.let { q.add(it) }
        }
        level++
        if (level == d) break
    }
    return root
}
