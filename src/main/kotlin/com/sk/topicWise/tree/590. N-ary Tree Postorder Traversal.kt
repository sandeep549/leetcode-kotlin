package com.sk.topicWise.tree

import com.sk.model.NTreeNode
import java.util.ArrayList
import java.util.Stack

// Recursive
private var list = mutableListOf<Int>()
private fun postorder(root: NTreeNode?): List<Int> {
    root?.let {
        it.children?.let {
            for (node in it) postorder(node)
        }
        list.add(root.`val`)
    }
    return list
}

// iterative, not verified on leetcode, no env. available to run for this question
@ExperimentalStdlibApi
private fun postorder2(root: NTreeNode?): List<Int> {
    val list: MutableList<Int> = ArrayList()
    if (root == null) return list

    val stack1 = Stack<NTreeNode>()
    val stack2 = Stack<NTreeNode>()
    stack1.add(root)

    while (!stack1.empty()) {
        val top = stack1.pop()
        stack2.push(top)
        top.children?.forEach { stack1.push(it) }
    }
    while (!stack2.empty()) {
        list.add(stack2.pop().`val`)
    }

    return list
}

private fun postorder3(root: NTreeNode?): List<Int> {
    val list: MutableList<Int> = ArrayList()
    if (root == null) return list

    val stack = Stack<NTreeNode>()
    stack.add(root)

    while (!stack.isEmpty()) {
        val root = stack.pop()
        list.add(root.`val`)
        root.children?.forEach { stack.add(it) }
    }
    list.reverse()
    return list
}

// print along the way
private fun postorder4(root: NTreeNode?): List<Int> {
    if (root == null) return emptyList()

    class CustomNode(val node: NTreeNode, var count: Int)

    val list = mutableListOf<Int>()

    val stack = Stack<CustomNode>()
    stack.add(CustomNode(root, -1))

    while (!stack.isEmpty()) {
        val cn = stack.pop()
        if (cn.node.children.isNullOrEmpty()) {
            list.add(cn.node.`val`)
            continue
        }
        if (cn.count == cn.node.children?.lastIndex) { // all children processed
            list.add(cn.node.`val`)
        } else {
            cn.count++ // point to next child
            stack.push(cn) // push back parent again
            val child = CustomNode(cn.node.children!![cn.count]!!, -1)
            stack.push(child)
        }
    }

    return list
}
