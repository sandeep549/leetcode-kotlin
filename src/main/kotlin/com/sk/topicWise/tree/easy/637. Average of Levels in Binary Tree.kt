package com.sk.topicWise.tree.easy

import com.sk.topicWise.tree.TreeNode

class Solution637 {
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        val list = arrayListOf<Pair<Int, Double>>()
        dfs(root, 0, list)
        return list.map { it.second / it.first }.toDoubleArray()
    }

    fun dfs(root: TreeNode?, level: Int, list: ArrayList<Pair<Int, Double>>) {
        if (root == null) {
            return
        }

        if (list.size <= level) {
            val p = Pair(1, root.`val`.toDouble())
            list.add(p)
        } else {
            val first = list[level].first + 1
            val second = list[level].second + root.`val`.toDouble()
            list[level] = Pair(first, second)
        }
        dfs(root.left, level + 1, list)
        dfs(root.right, level + 1, list)
    }

    fun averageOfLevels2(root: TreeNode?): DoubleArray {
        val list = arrayListOf<Double>()
        if (root == null) {
            return list.toDoubleArray()
        }
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)
        while (!queue.isEmpty()) {
            val count = queue.size
            var size = count
            var sum = 0.0
            while (size > 0) {
                val cur = queue.removeFirst()
                sum += cur.`val`
                cur.left?.let { queue.add(it) }
                cur.right?.let { queue.add(it) }
                size--
            }
            list.add(sum / count)
        }
        return list.toDoubleArray()
    }
}

