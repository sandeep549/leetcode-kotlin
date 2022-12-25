package leetcode.kotlin.dp

import leetcode.kotlin.tree.TreeNode

private class SolutionHouseRobber {
    fun rob(root: TreeNode?): Int {
        val (withRoot, withoutRoot) = traverse(root)
        return maxOf(withRoot, withoutRoot)
    }

    private fun traverse(node: TreeNode?): Loot {
        if (node == null) return Loot(0, 0)
        val left = traverse(node.left)
        val right = traverse(node.right)

        // when rob current node
        val withRoot = left.withoutRoot + right.withoutRoot + node.`val`
        // When don't rob this node
        val withoutRoot = maxOf(left.withRoot, left.withoutRoot) + maxOf(right.withRoot, right.withoutRoot)

        return Loot(withRoot, withoutRoot)
    }

    data class Loot(val withRoot: Int, val withoutRoot: Int)
}
