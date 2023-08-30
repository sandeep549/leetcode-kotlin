package com.sk.topicWise.tree

// based on level order traversal
private fun connect(root: Node?) {
    var head: Node? = null // head of the next level
    var prev: Node? = null // the leading node on the next level
    var cur: Node? = root // current node of current level
    while (cur != null) {
        while (cur != null) { // iterate on the current level
            // left child
            if (cur.left != null) {
                if (prev != null) {
                    prev.next = cur.left
                } else {
                    head = cur.left
                }
                prev = cur.left
            }

            // right child
            if (cur.right != null) {
                if (prev != null) {
                    prev.next = cur.right
                } else {
                    head = cur.right
                }
                prev = cur.right
            }
            // move to next node
            cur = cur.next
        }

        // move to next level
        cur = head
        head = null
        prev = null
    }
}
