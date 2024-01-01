package com.sk.z_ImportantCodeSnippet

import com.sk.topicWise.tree.TreeNode

private fun preorderTraversal2(root: TreeNode?): List<Int> {
    val list = mutableListOf<Int>()
    if(root == null) return list
    val s = ArrayDeque<TreeNode>()
    s.addLast(root)
    while(s.isNotEmpty()) {
        val node = s.removeLast()
        list.add(node.`val`)
        node.right?.let { s.addLast(it) }
        node.left?.let { s.addLast(it) }
    }
    return list
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

private fun postorderTraversal2(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    val stack = ArrayDeque<TreeNode>()
    if (root == null) {
        return result
    }

    stack.addLast(root)
    var cur = root
    var pre: TreeNode? = null
    while (!stack.isEmpty()) {
        cur = stack.first()
        if (cur!!.left == null && cur.right == null || pre != null && (pre == cur.left || pre == cur.right)) {
            result.add(cur.`val`) // deal with topological dependency
            stack.removeLast() // stack top value is processed, remove it now
            pre = cur // for backtracking
        } else {
            if (cur.right != null) {
                stack.addLast(cur.right!!)
            }
            if (cur.left != null) {
                stack.addLast(cur.left!!)
            }
        }
    }

    return result
}
