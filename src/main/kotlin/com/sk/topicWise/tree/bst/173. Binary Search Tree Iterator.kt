package com.sk.topicWise.tree.bst

import com.sk.topicWise.tree.TreeNode

/**
 * Process while calling next()
 */
class Solution173(root: TreeNode?) {
    val s = ArrayDeque<TreeNode>()

    init {
        push(root)
    }

    fun next(): Int {
        return pop()
    }

    fun hasNext(): Boolean {
        return s.isNotEmpty()
    }

    private fun push(n: TreeNode?) {
        var node = n
        while (node != null) {
            s.addLast(node)
            node = node.left
        }
    }

    private fun pop(): Int {
        val n = s.removeLast()
        push(n.right)
        return n.`val`
    }
}

/**
 * Pre-process the tree using recursion.
 */
class Solution173_2(root: TreeNode?) {
    private var sortedList = mutableListOf<Int>()
    private var index = -1

    init {
        inroder(root)
    }

    private fun inroder(node: TreeNode?) {
        if (node == null) return
        inroder(node.left)
        sortedList.add(node.`val`)
        inroder(node.right)
    }

    fun next(): Int {
        return if (hasNext()) sortedList[++index] else -1
    }

    fun hasNext(): Boolean {
        return (index + 1) < sortedList.size
    }
}

