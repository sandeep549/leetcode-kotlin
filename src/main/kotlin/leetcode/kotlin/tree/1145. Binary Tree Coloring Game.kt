package leetcode.kotlin.tree

private fun btreeGameWinningMove(root: TreeNode?, n: Int, x: Int): Boolean {
    var leftCount = 0
    var rightCount = 0
    fun count(root: TreeNode?): Int {
        root?.let {
            val l = count(it.left)
            val r = count(it.right)
            if (it.`val` == x) {
                leftCount = l
                rightCount = r
            }
            return l + r + 1
        }
        return 0
    }
    count(root)

    if (
        leftCount > n / 2 ||
        rightCount > n / 2 ||
        leftCount + rightCount + 1 < (n + 1) / 2
    )
        return true

    return false
}
