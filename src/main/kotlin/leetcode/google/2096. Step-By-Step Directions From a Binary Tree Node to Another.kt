package leetcode.google

import leetcode.kotlin.tree.TreeNode

fun getDirections(
    root: TreeNode?,
    startValue: Int, destValue: Int
): String {
    val s = StringBuilder()
    dfs(root, startValue, s)

    val e = StringBuilder()
    dfs(root, destValue, e)

    s.reverse()
    e.reverse()

    val c = s.commonPrefixWith(e).length

    return "U".repeat(s.length - c) + e.substring(c)
}

fun dfs(root: TreeNode?, target: Int, sb: StringBuilder): Boolean {
    if (root == null) return false
    if (root.`val` == target) {
        return true
    }
    if (dfs(root.left, target, sb)) {
        sb.append("L")
        return true
    }
    if (dfs(root.right, target, sb)) {
        sb.append("R")
        return true
    }

    return false
}
