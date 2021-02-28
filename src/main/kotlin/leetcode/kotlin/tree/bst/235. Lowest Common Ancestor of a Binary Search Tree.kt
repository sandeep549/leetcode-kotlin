package leetcode.kotlin.tree.bst

import leetcode.kotlin.tree.TreeNode

private fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root == null) return root
    val parentVal: Int = root.`val`
    val pVal: Int = p!!.`val`
    val qVal: Int = q!!.`val`
    return if (pVal > parentVal && qVal > parentVal) {
        lowestCommonAncestor(root.right, p, q)
    } else if (pVal < parentVal && qVal < parentVal) {
        lowestCommonAncestor(root.left, p, q)
    } else {
        return root // either both are on different side, or one is same as current root
    }
}

private fun lowestCommonAncestor2(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root == null) return root
    val pVal: Int = p!!.`val`
    val qVal: Int = q!!.`val`
    var node = root
    while (true) {
        val parentVal: Int = node!!.`val`
        if (pVal > parentVal && qVal > parentVal) node = node.right
        else if (pVal < parentVal && qVal < parentVal) node = node.left
        else break
    }
    return node
}
