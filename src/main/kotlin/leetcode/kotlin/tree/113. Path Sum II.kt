package leetcode.kotlin.tree

private fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
    val res = mutableListOf<MutableList<Int>>()
    fun dfs(root: TreeNode?, path: MutableList<Int>, sum: Int) {
        root?.let { root ->
            path.add(root.`val`)
            var sumHere = sum + root.`val`
            if (root.left == root.right && sumHere == targetSum) {
                res.add(path)
            } else {
                val list = mutableListOf<Int>()
                list.addAll(path)
                root.left?.let { dfs(it, list, sumHere) }
                root.right?.let { dfs(it, path, sumHere) }
            }
        }
    }
    dfs(root, mutableListOf<Int>(), 0)
    return res
}
