package topicWise.tree

// not tested, please re-test it
private fun averageOfLevels(root: TreeNode?): DoubleArray {
    var list = ArrayList<Pair<Int, Double>>()
    fun dfs(root: TreeNode, level: Int) {
        if (list.size <= level) list.add(Pair(level, root.`val`.toDouble()))
        else list[level] = Pair(level, list[level].second + root.`val`.toDouble())
        root.left?.let { dfs(it, level + 1) }
        root.right?.let { dfs(it, level + 1) }
    }
    root?.let { dfs(it, 0) }
    return list.map { it.second / it.first }.toDoubleArray()
}

@ExperimentalStdlibApi
private fun averageOfLevels2(root: TreeNode?): DoubleArray {
    val list: MutableList<Double> = ArrayList()
    val queue = ArrayDeque<TreeNode>()
    queue.add(root!!)
    while (!queue.isEmpty()) {
        val count: Int = queue.size
        var size = count
        var sum = 0.0
        while (size-- > 0) {
            val cur: TreeNode = queue.removeFirst()
            sum += cur.`val`
            cur.left?.let { queue.add(it) }
            cur.right?.let { queue.add(it) }
        }
        list.add(sum / count)
    }
    return list.toDoubleArray()
}
