package com.sk.set15

import com.sk.topicWise.tree.TreeNode

class Solution1530 {

    var goodLeafs = 0
    fun countPairs(root: TreeNode?, distance: Int): Int {
        this.goodLeafs = 0
        dfs(root, distance)
        return goodLeafs
    }

    private fun dfs(node: TreeNode?, allowed: Int): MutableList<Int> {
        if (node == null) return mutableListOf()
        if (node?.left == null && node?.right == null) {
            return mutableListOf(1)
        }

        var leftList = dfs(node?.left, allowed)
        var rightList = dfs(node?.right, allowed)

        for (l in leftList) {
            for (r in rightList) {
                if (l + r <= allowed) goodLeafs++
            }
        }

        leftList.addAll(rightList)
        return leftList.map { it + 1 }.filter { it < allowed }.toMutableList()
    }
}