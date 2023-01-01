package topicWise.tree

private class Solution {
    var ans = "~"
    fun smallestFromLeaf(root: TreeNode?): String {
        dfs(root, StringBuilder())
        return ans
    }

    fun dfs(node: TreeNode?, sb: StringBuilder) {
        if (node == null) return
        sb.append(('a'.toInt() + node.`val`).toChar())
        if (node.left == null && node.right == null) {
            sb.reverse()
            val S = sb.toString()
            sb.reverse()
            if (S.compareTo(ans) < 0) ans = S
        }
        dfs(node.left, sb)
        dfs(node.right, sb)
        sb.deleteCharAt(sb.length - 1)
    }
}
