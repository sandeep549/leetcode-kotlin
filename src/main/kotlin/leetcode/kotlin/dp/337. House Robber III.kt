package leetcode.kotlin.dp

import leetcode.kotlin.tree.TreeNode

private class SolutionHouseRobber {
    fun rob(root: TreeNode?): Int {
        val answers = internalrob(root)
        println(answers.toList())
        return maxOf(answers[0], answers[1])
    }

    private fun internalrob(root: TreeNode?): IntArray {
        root?.let {
            val left = internalrob(it.left)
            val right = internalrob(it.right)
            val max_including_cur = maxOf(left[1], right[1]) + it.`val`
            val max_exluding_cur = maxOf(left[0], left[1]) + maxOf(right[0], right[1])
            return intArrayOf(max_including_cur, max_exluding_cur)
        }
        return intArrayOf(0, 0)
    }
}