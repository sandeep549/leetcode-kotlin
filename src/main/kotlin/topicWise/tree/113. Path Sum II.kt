package topicWise.tree

private fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
    val res = mutableListOf<MutableList<Int>>()
    fun dfs(root: TreeNode?, path: MutableList<Int>, sum: Int) {
        root?.let { rt ->
            path.add(rt.`val`)
            val sumHere = sum + rt.`val`
            if (rt.left == rt.right && sumHere == targetSum) {
                res.add(path)
            } else {
                val list = mutableListOf<Int>()
                list.addAll(path)
                rt.left?.let { dfs(it, list, sumHere) }
                rt.right?.let { dfs(it, path, sumHere) }
            }
        }
    }
    dfs(root, mutableListOf<Int>(), 0)
    return res
}
