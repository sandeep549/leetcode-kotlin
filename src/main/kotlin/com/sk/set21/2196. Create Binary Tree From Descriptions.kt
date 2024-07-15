package com.sk.set21

import com.sk.topicWise.tree.TreeNode

class Solution2196 {
    fun createBinaryTree(descriptions: Array<IntArray>): TreeNode? {
        val parentToChildMap = mutableMapOf<Int, Pair<Int, Int>>()
        val allChild = mutableSetOf<Int>()
        descriptions.forEach { (parent, child, isLeft) ->
            var (left, right) = parentToChildMap.getOrDefault(parent, Pair(0, 0))
            if (isLeft == 1) left = child else right = child
            parentToChildMap[parent] = Pair(left, right)
            allChild.add(left)
            allChild.add(right)
        }

        var parent = 0
        for (desc in descriptions) {
            if (allChild.contains(desc[0]).not()) {
                parent = desc[0]
                break
            }
        }

        return makeTree(parent, parentToChildMap)
    }

    private fun makeTree(value: Int, parentToChildMap: MutableMap<Int, Pair<Int, Int>>): TreeNode? {
        val node = TreeNode(value)
        val (leftValue, rightValue) = parentToChildMap[value] ?: return node
        if (leftValue != 0) {
            node.left = makeTree(leftValue, parentToChildMap)
        }
        if (rightValue != 0) {
            node.right = makeTree(rightValue, parentToChildMap)
        }
        return node
    }
}