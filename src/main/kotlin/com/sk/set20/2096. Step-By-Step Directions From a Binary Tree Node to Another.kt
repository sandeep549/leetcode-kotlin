package com.sk.set20

import com.sk.topicWise.tree.TreeNode

class Solution2096 {

    fun getDirections(root: TreeNode?, startValue: Int, destValue: Int): String {
        val pathToStart = StringBuilder()
        dfs(root, startValue, pathToStart)

        val pathToDestination = StringBuilder()
        dfs(root, destValue, pathToDestination)

        pathToStart.reverse()
        pathToDestination.reverse()

        val commonPrefixLen = pathToStart.commonPrefixWith(pathToDestination).length

        return "U".repeat(pathToStart.length - commonPrefixLen) + pathToDestination.substring(commonPrefixLen)
    }

    private fun dfs(root: TreeNode?, target: Int, sb: StringBuilder): Boolean {
        if (root == null) return false
        if (root.`val` == target) {
            return true
        }
        if (dfs(root.left, target, sb)) {
            sb.append("L")
            return true
        }
        if (dfs(root.right, target, sb)) {
            sb.append("R")
            return true
        }

        return false
    }

}