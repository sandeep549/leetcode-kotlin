package topicWise.tree

private fun longestUnivaluePath(root: TreeNode?): Int {
    var maxSoFar = 0

    class Data(val ele: Int, var count: Int)

    fun dfs(root: TreeNode?): Data {
        root?.let {
            val ld = dfs(it.left)
            val rd = dfs(it.right)
            val cur = it.`val`
            if (ld.ele == rd.ele && ld.ele == cur) {
                maxSoFar = maxOf(maxSoFar, ld.count + rd.count + 1)
                return Data(cur, maxOf(ld.count, rd.count) + 1)
            } else if (ld.ele == cur) {
                maxSoFar = maxOf(maxSoFar, ld.count + 1)
                return Data(cur, ld.count + 1)
            } else if (rd.ele == cur) {
                maxSoFar = maxOf(maxSoFar, rd.count + 1)
                return Data(cur, rd.count + 1)
            } else {
                return Data(cur, 1)
            }
        }
        return Data(-1001, 0)
    }
    dfs(root)
    return if (maxSoFar > 0) --maxSoFar else maxSoFar
}
