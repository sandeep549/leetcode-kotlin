package topicWise.tree

// use of global k is discouraged??
private fun kthSmallest(root: TreeNode?, k: Int): Int {
    var k = k
    var ans = 0
    fun inorder(root: TreeNode?) {
        if (k == 0 || root == null) return
        inorder(root.left)
        if (--k == 0) ans = root.`val`
        inorder(root.right)
    }
    inorder(root)
    return ans
}

@ExperimentalStdlibApi
private fun kthSmallest3(root: TreeNode?, k: Int): Int {
    val stack = ArrayDeque<TreeNode>()
    var root = root
    var k = k
    while (true) {
        while (root != null) {
            stack.addLast(root)
            root = root.left
        }
        root = stack.removeLast()
        if (--k == 0) return root.`val`
        root = root.right
    }
}
