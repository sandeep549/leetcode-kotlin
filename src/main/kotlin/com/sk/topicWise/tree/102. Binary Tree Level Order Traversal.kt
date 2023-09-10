package com.sk.topicWise.tree

/**
 * Queue methods
 * Add() -- adds at tail in ArrayDeque
 * remove() -- remove from front in ArrayDeque
 *
 * offer() -- adds at tail in ArrayDeque
 * poll() -- remove from front in ArrayDeque
 */
@ExperimentalStdlibApi
private fun levelOrder(root: TreeNode?): List<List<Int>> {
    val res = mutableListOf<MutableList<Int>>()
    if (root == null) return res
    val q = ArrayDeque<TreeNode>()
    q.add(root)
    while (q.isNotEmpty()) {
        var size = q.size
        val list = mutableListOf<Int>()
        while (size-- > 0) {
            val node = q.removeFirst()
            list.add(node.`val`)
            node.left?.let { q.add(it) }
            node.right?.let { q.add(it) }
        }
        res.add(list)
    }
    return res
}

// todo: do it with recursion
