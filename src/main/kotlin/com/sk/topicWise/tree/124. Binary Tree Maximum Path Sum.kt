package com.sk.topicWise.tree

class Solution124 {
    /**
     * Traverse the tree and while backtrack, maintain mas_so_far at every node, return max passing through
     * current node. We need to return values for first 3 cases from below, 4th case will be considered
     * in max_so_far
     *
     * For each node there can be four ways that the max path goes through the node:
     * 1. Node only
     * 2. Max path through Left Child + Node
     * 3. Max path through Right Child + Node
     * 4. Max path through Left Child + Node + Max path through Right Child
     */
    fun maxPathSum(root: TreeNode?): Int {
        return dfs(root).max()
    }

    private fun dfs(root: TreeNode?): IntArray {
        if (root == null) return intArrayOf(-1001, -1001)
        val larr = dfs(root.left)
        val rarr = dfs(root.right)

        // max path till now
        val max_so_far = larr[1] // max so far from left side
            .coerceAtLeast(larr[0] + root.`val`) // max going through curr + left
            .coerceAtLeast(rarr[1]) // max so far from right side
            .coerceAtLeast(rarr[0] + root.`val`) // max going through curr + right
            .coerceAtLeast(root.`val`) // only this node
            .coerceAtLeast(larr[0] + root.`val` + rarr[0]) // left + node + right

        val max_passing_through = root.`val`
            .coerceAtLeast(larr[0] + root.`val`)
            .coerceAtLeast(rarr[0] + root.`val`)

        return intArrayOf(max_passing_through, max_so_far)
    }
}

