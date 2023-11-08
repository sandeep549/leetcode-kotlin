package com.sk.topicWise.tree.medium

import com.sk.topicWise.tree.Node

class Solution117 {
    fun connect(root: Node?): Node? {
        if (root == null) return null
        val q = ArrayDeque<Node>()
        q.add(root)
        while (q.isNotEmpty()) {
            var size = q.size
            while (size > 0) {
                val n = q.removeFirst()
                n.next = if (size == 1) null else q.first()
                n.left?.let { q.add(it) }
                n.right?.let { q.add(it) }
                size--
            }
        }
        return root
    }

    private fun connect2(root: Node?): Node? {
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
        return root
    }
}

