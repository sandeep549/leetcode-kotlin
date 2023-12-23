package com.sk.set5

import com.sk.topicWise.tree.TreeNode


class Solution501 {
    private var currVal = 0
    private var currCount = 0
    private var maxCount = 0
    private var modeCount = 0
    private var modes: IntArray? = null

    fun findMode(root: TreeNode?): IntArray {
        inorder(root)
        modes = IntArray(modeCount)
        modeCount = 0
        currCount = 0
        inorder(root)
        return modes as IntArray
    }

    private fun handleValue(`val`: Int) {
        if (`val` != currVal) {
            currVal = `val`
            currCount = 0
        }
        currCount++
        if (currCount > maxCount) {
            maxCount = currCount
            modeCount = 1
        } else if (currCount == maxCount) {
            if (modes != null) modes!![modeCount] = currVal
            modeCount++
        }
    }

    private fun inorder(root: TreeNode?) {
        if (root == null) return
        inorder(root.left)
        handleValue(root.`val`)
        inorder(root.right)
    }
}

class Solution501_2 {
    fun findMode(root: TreeNode?): IntArray {
        val res = mutableListOf<Int>()
        var maxCount = 0
        var count = 0
        var prev = Int.MAX_VALUE
        fun dfs(n: TreeNode) {
            n.left?.let { dfs(it) }
            if (prev == n.`val`) {
                count++
            } else {
                count = 1
                prev = n.`val`
            }
            if (count == maxCount) {
                res += n.`val`
            } else if (count > maxCount) {
                maxCount = count
                res.clear()
                res += n.`val`
            }
            n.right?.let { dfs(it) }
        }
        root?.let { dfs(it) }
        return res.toIntArray()
    }
}