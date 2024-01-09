package com.sk.`todo-revise`

import com.sk.topicWise.tree.TreeNode
import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.MutableList
import kotlin.collections.isNotEmpty
import kotlin.collections.mutableListOf


class Solution872 {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        fun dfs(node: TreeNode?, list: MutableList<Int>) {
            if (node == null) return
            if (node.left == null && node.right == null) {
                list.add(node.`val`)
            }
            dfs(node.left, list)
            dfs(node.right, list)
        }

        val l1 = mutableListOf<Int>()
        dfs(root1, l1)

        val l2 = mutableListOf<Int>()
        dfs(root2, l2)

        return l1 == l2
    }

    // https://leetcode.com/problems/leaf-similar-trees/solutions/152329/c-java-python-o-h-space
    fun leafSimilar2(root1: TreeNode?, root2: TreeNode?): Boolean {
        fun nextLeaf(s: ArrayDeque<TreeNode>): Int {
            while (true) {
                val node = s.removeLast()
                node.right?.let { s.addLast(it) }
                node.left?.let { s.addLast(it) }
                if (node.left == null && node.right == null) return node.`val`
            }
        }

        val s1 = ArrayDeque<TreeNode>()
        s1.addLast(root1!!)
        val s2 = ArrayDeque<TreeNode>()
        s2.addLast(root2!!)

        while (s1.isNotEmpty() && s2.isNotEmpty()) {
            if (nextLeaf(s1) != nextLeaf(s2)) {
                return false
            }
        }

        return s1.isEmpty() && s2.isEmpty()
    }

}