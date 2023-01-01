package topicWise.tree

import java.util.Stack

// backtracking
/**
 * Traverse the tree in dfs, and while backtrack, keep track of 2 things
 * 1. Farthest leaf node distance from current node, return it to caller adding 1 more edge
 * 2. Max diameter under this node
 *
 * Every node will return max length path available under it.
 * For every node calculate max distance by adding max length on left and right side of it,
 * and keep track'of max found so far.
 */
private fun diameterOfBinaryTree2(root: TreeNode?): Int {
    var ans = 0
    fun dfs(root: TreeNode?): Int {
        if (root == null) return 0
        var l = dfs(root.left)
        var r = dfs(root.right)
        ans = maxOf(ans, l + r)
        return maxOf(l, r) + 1
    }
    dfs(root)
    return ans
}

fun diameterOfBinaryTree(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    var maxSoFar = 0
    val s = Stack<TreeNode>()
    val map = mutableMapOf<TreeNode, Int>()
    s.push(root)
    while (!s.isEmpty()) {
        val node = s.peek() // kotlin ArrayDeque doesn't have peek yet, so experimental
        if (node.left != null && !map.containsKey(node.left!!)) {
            s.push(node.left)
        } else if (node.right != null && !map.containsKey(node.right!!)) {
            s.push(node.right)
        } else {
            val cur = s.pop()
            val lmax = if (cur.left != null) map.getOrDefault(cur.left!!, 0) else 0
            val rmax = if (cur.right != null) map.getOrDefault(cur.right!!, 0) else 0
            val nodeMax = maxOf(lmax, rmax) + 1
            map[cur] = nodeMax
            maxSoFar = maxOf(maxSoFar, lmax + rmax)
        }
    }
    return maxSoFar
}
