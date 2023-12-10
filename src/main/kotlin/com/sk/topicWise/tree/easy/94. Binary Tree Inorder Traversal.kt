package com.sk.topicWise.tree.easy

import com.sk.topicWise.tree.TreeNode


// TODO check morris traversal also

private fun inorderTraversal(root: TreeNode?): List<Int> {
    val list = mutableListOf<Int>()
    helper(root, list)
    return list
}

private fun helper(root: TreeNode?, list: MutableList<Int>) {
    if (root != null) {
        helper(root.left, list)
        list.add(root.`val`)
        helper(root.right, list)
    }
}

private fun inorderTraversal2(root: TreeNode?): List<Int> {
    val list = ArrayList<Int>()
    var curr = root
    val stack = ArrayDeque<TreeNode>() // Stack is legacy and deprecated
    while (curr != null || !stack.isEmpty()) {
        while (curr != null) {
            stack.addLast(curr)
            curr = curr.left
        }
        curr = stack.removeLast()
        list.add(curr.`val`)
        curr = curr.right
    }
    return list
}

private fun inorderTraversal3(root: TreeNode?): List<Int> {
    val list = ArrayList<Int>()
    var curr = root
    val stack = ArrayDeque<TreeNode>() // Stack is legacy and deprecated
    while (curr != null || !stack.isEmpty()) {
        if (curr != null) {
            stack.addLast(curr)
            curr = curr.left
        } else {
            curr = stack.removeLast()
            list.add(curr.`val`)
            curr = curr.right
        }
    }
    return list
}
