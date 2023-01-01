package topicWise.tree

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

private fun connect(root: Node?): Node? {
    var levelStart = root
    while (levelStart != null) {
        var cur = levelStart
        while (cur != null) {
            cur.left?.let { it.next = cur?.right }
            if (cur.right != null && cur.next != null) cur.right?.next = cur.next?.left
            cur = cur.next
        }
        levelStart = levelStart.left
    }
    return root
}
