package topicWise.tree

import model.TreeNode
import java.util.ArrayDeque
import java.util.LinkedList
import java.util.Stack

private fun preorderTraversal(root: TreeNode?): List<Int> {
    val output: MutableList<Int> = ArrayList()
    dfs(root)
    return output
}

fun dfs(root: TreeNode?, list: MutableList<Int>) {
    if (root == null) return
    list.add(root.`val`)
    dfs(root.left)
    dfs(root.right)
}

// iterative-1
private fun preorderTraversal2(root: TreeNode?): List<Int> {
    val list = mutableListOf<Int>()
    if(root == null) return list
    val s = ArrayDeque<TreeNode>()
    s.push(root)
    while(s.isNotEmpty()) {
        val node = s.pop()
        list.add(node.`val`)
        node.right?.let { s.push(it) }
        node.left?.let { s.push(it) }
    }
    return list
}

// iterative-2
// only store right children to the stack
private fun preorderTraversal3(root: TreeNode?): List<Int> {
    val list: MutableList<Int> = LinkedList()
    val rights = Stack<TreeNode>()
    var node = root
    while (node != null) {
        list.add(node.`val`)
        if (node.right != null) {
            rights.push(node.right)
        }
        node = node.left
        if (node == null && !rights.isEmpty()) {
            node = rights.pop()
        }
    }
    return list
}
