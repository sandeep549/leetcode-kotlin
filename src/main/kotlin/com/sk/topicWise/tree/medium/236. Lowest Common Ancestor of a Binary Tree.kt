package com.sk.topicWise.tree.medium

import com.sk.topicWise.tree.TreeNode

class Solution236_1 {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || root === p || root === q) return root
        val left = lowestCommonAncestor(root.left, p, q)
        val right = lowestCommonAncestor(root.right, p, q)
        return if (left != null && right != null) root else left ?: right
    }
}

class Solution236_2 {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        val parent = HashMap<TreeNode?, TreeNode?>()
        val queue = ArrayDeque<TreeNode>()
        queue.add(root!!)
        parent[root] = null

        // Traverse to p and q, and make parent map
        while (parent.containsKey(p).not() || parent.containsKey(q).not()) {
            val n = queue.removeLast()
            if (n.left != null) {
                parent[n.left!!] = n
                queue.add(n.left!!)
            }
            if (n.right != null) {
                parent[n.right!!] = n
                queue.add(n.right!!)
            }
        }

        val ancestors = HashSet<TreeNode>()

        // Traverse upward from p to root, make set of path
        var c = p
        while (c != null) {
            ancestors.add(c)
            c = parent[c]
        }

        // Traverse in q parent and find common parent
        c = q
        while (ancestors.contains(c).not()) {
            c = parent[c]
        }

        return c
    }
}
