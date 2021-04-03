package leetcode.kotlin.tree

class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}

private class Solution3 {
    @ExperimentalStdlibApi
    fun connect(root: Node?): Node? {
        val q = ArrayDeque<Node>()
        root?.let { q.add(it) }
        while (q.isNotEmpty()) {
            var size = q.size
            var pre: Node? = null
            while (size > 0) {
                val node = q.removeFirst()
                node.left?.let { q.add(it) }
                node.right?.let { q.add(it) }
                pre?.let { it.right = node }
                pre = node
                size--
            }
        }
        return root
    }
}