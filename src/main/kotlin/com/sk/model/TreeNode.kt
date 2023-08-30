package com.sk.model

/**
 * Binary tree node
 */
class TreeNode(var `val`: Int) {
    constructor(`val`: Int, left: TreeNode?, right: TreeNode?) : this(`val`) {
        this.left = left
        this.right = right
    }

    // only to be used in special cases when asked,otherwise not available
    var parent: TreeNode? = null
    var left: TreeNode? = null
    var right: TreeNode? = null
}
