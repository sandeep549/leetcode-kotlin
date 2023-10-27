package com.sk.topicWise.tree.bst

import com.sk.topicWise.tree.TreeNode

class Solution108 {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return tree(nums, 0, nums.size - 1)
    }

    private fun tree(nums: IntArray, l: Int, r: Int): TreeNode? {
        if (l > r) return null
        if (l == r) return TreeNode(nums[l])

        val m = l + (r - l) / 2
        val n = TreeNode(nums[m])
        n.left = tree(nums, l, m - 1)
        n.right = tree(nums, m + 1, r)
        return n
    }
}

// todo: can we do it iteratively?
