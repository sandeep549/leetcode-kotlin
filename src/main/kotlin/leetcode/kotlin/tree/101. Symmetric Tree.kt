package leetcode.kotlin.tree

import java.util.LinkedList

//import kotlin.collections.ArrayDeque

private fun isSymmetric(root: TreeNode?): Boolean {
    fun isMirror(n1: TreeNode?, n2: TreeNode?): Boolean {
        if (n1 == null && n2 == null) return true
        if (n1 == null || n2 == null) return false
        return (n1.`val` == n2.`val`)
            && isMirror(n1.left, n2.right)
            && isMirror(n1.right, n2.left)
    }
    if (root == null) return true
    return isMirror(root.left, root.right)
}

// todo: Leetcode supports Kotlin 1.3.10, which doesn't have ArrayDeque yet
@ExperimentalStdlibApi
private fun isSymmetric2(root: TreeNode?): Boolean {
    if (root == null) return true
    val queue = ArrayDeque<TreeNode?>()
    queue.add(root.left)
    queue.add(root.right)
    while (!queue.isEmpty()) {
        val n1 = queue.removeFirst()
        val n2 = queue.removeFirst()
        if (n1 == null && n2 == null) continue
        if (n1 == null || n2 == null) return false
        if (n1.`val` != n2.`val`) return false
        with(queue) {
            add(n1.left)
            add(n2.right)
            add(n1.right)
            add(n2.left)
        }
    }
    return true
}

private fun isSymmetric3(root: TreeNode?): Boolean {
    if (root == null) return true
    val queue = LinkedList<TreeNode?>()
    queue.add(root.left)
    queue.add(root.right)
    while (!queue.isEmpty()) {
        val n1 = queue.poll()
        val n2 = queue.poll()
        if (n1 == null && n2 == null) continue
        if (n1 == null || n2 == null) return false
        if (n1.`val` != n2.`val`) return false
        with(queue) {
            add(n1.left) // LinkedList allowes null, but ArrayDeque doesn't
            add(n2.right)
            add(n1.right)
            add(n2.left)
        }
    }
    return true
}
