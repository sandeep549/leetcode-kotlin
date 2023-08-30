package com.sk.topicWise.tree

import model.TreeNode

private fun minDepth(root: TreeNode?): Int {
    if (root == null) return 0
    val l = minDepth(root.left)
    val r = minDepth(root.right)
    return if (l == 0 || r == 0) l + r + 1 else minOf(l, r) + 1
}

@ExperimentalStdlibApi
private fun minDepth2(root: TreeNode?): Int {
    var depth = 0
    if (root == null) return depth
    val queue = ArrayDeque<TreeNode>()
    queue.add(root)
    while (!queue.isEmpty()) {
        var width = queue.size
        while (width > 0) {
            val node = queue.removeFirst()
            if (node.left == node.right) return depth + 1
            node.left?.let { queue.add(it) }
            node.right?.let { queue.add(it) }
            width--
        }
        depth++
    }
    return 0
}
