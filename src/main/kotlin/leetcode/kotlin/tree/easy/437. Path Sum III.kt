package leetcode.kotlin.tree.easy

private fun pathSum(root: TreeNode?, sum: Int): Int {
    var ans = 0
    fun dfs(root: TreeNode?): MutableList<ArrayList<Int>> {
        root?.let {
            var l = dfs(it.left)
            var r = dfs(it.right)
            var lret = mutableListOf<ArrayList<Int>>()
            var rret = mutableListOf<ArrayList<Int>>()
            for (list in l) {
                var lsum = list.sum()
                if (lsum + it.`val` == sum) ans++
                else if (lsum + it.`val` < sum) {
                    list.add(it.`val`)
                    lret.add(list)
                }
            }
            for (list in r) {
                var lsum = list.sum()
                if (lsum + it.`val` == sum) ans++
                else if (lsum + it.`val` < sum) {
                    list.add(it.`val`)
                    rret.add(list)
                }
            }
            for (list in lret) {
                for (list2 in rret) {
                    if (list.sum() + list2.sum() == sum) ans++
                }
            }
            lret.addAll(rret)
            return lret
        }
        return mutableListOf<ArrayList<Int>>()
    }
    dfs(root)
    return ans
}

private fun pathSum2(root: leetcode.kotlin.tree.TreeNode?, sum: Int): Int {
    var count = 0
    fun dfs(root: leetcode.kotlin.tree.TreeNode?, paths: MutableList<Int>) {
        root?.let {
            for (i in paths.indices) paths[i] += it.`val`
            paths.add(it.`val`)
            for (pathsum in paths) if (pathsum == sum) count++
            val copyPath = mutableListOf<Int>()
            paths.forEach { copyPath.add(it) }
            dfs(it.left, paths)
            dfs(it.right, copyPath)
        }
    }
    dfs(root, mutableListOf())
    return count
}
