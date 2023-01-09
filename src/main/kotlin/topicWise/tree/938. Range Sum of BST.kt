package topicWise.tree

import model.TreeNode
import java.util.Stack

private fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
    var ans = 0
    fun dfs(node: TreeNode?) {
        node?.let {
            if (it.`val` >= low && it.`val` <= high) ans += it.`val`
            if (node.`val` > low) dfs(it.left)
            if (node.`val` < high) dfs(it.right)
        }
    }
    dfs(root)
    return ans
}

private fun rangeSumBST2(root: TreeNode?, L: Int, R: Int): Int {
    var ans = 0
    val stack = Stack<TreeNode?>()
    stack.push(root)
    while (!stack.isEmpty()) {
        val node = stack.pop()
        if (node != null) {
            if (node.`val` in L..R) ans += node.`val`
            if (L < node.`val`) stack.push(node.left)
            if (node.`val` < R) stack.push(node.right)
        }
    }
    return ans
}
