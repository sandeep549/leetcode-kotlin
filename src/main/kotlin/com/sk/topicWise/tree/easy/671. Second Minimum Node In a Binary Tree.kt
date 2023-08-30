package com.sk.topicWise.tree.easy

@ExperimentalStdlibApi
private fun findSecondMinimumValue(root: TreeNode?): Int {
    if (root == null) return -1
    val min = root.`val`
    var min2 = -1
    val q = ArrayDeque<TreeNode>()
    q.add(root)
    while (!q.isEmpty()) {
        var width = q.size
        while (width-- > 0) {
            val node = q.removeFirst()
            if (node.`val` > min && min2 == -1) {
                min2 = node.`val`
            }
            if (node.`val` > min && node.`val` < min2) {
                min2 = node.`val`
            }
            node.left?.let { q.add(it) }
            node.right?.let { q.add(it) }
        }
    }
    return min2
}

private fun findSecondMinimumValue2(root: TreeNode?): Int {
    if (root!!.left == null) return -1
    val l =
        if (root.left!!.`val` == root.`val`) findSecondMinimumValue2(root.left) else root.left!!.`val`
    val r =
        if (root.right!!.`val` == root.`val`) findSecondMinimumValue2(root.right) else root.right!!.`val`

    return if (l == -1 || r == -1) maxOf(l, r) else minOf(l, r)
}
