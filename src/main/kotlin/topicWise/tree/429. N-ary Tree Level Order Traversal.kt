package topicWise.tree

import model.NTreeNode

@ExperimentalStdlibApi
private fun levelOrder(root: NTreeNode?): List<List<Int>> {
    val ans = mutableListOf<MutableList<Int>>()
    val q = ArrayDeque<NTreeNode>()
    root?.let { q.add(it) }
    while (q.isNotEmpty()) {
        val list = mutableListOf<Int>()
        var size = q.size
        while (size-- > 0) {
            val first = q.removeFirst()
            list.add(first.`val`)
            first.children?.forEach { q.add(it) }
        }
        ans.add(list)
    }
    return ans
}
