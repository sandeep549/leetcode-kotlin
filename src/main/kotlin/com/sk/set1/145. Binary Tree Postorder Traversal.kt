package com.sk.set1

import com.sk.topicWise.tree.TreeNode


class Solution145 {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        val stack = ArrayDeque<TreeNode>()
        var curr = root
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                result.add(curr.`val`) // Add before going to children
                stack.addLast(curr)
                curr = curr.right
            } else {
                curr = stack.removeLast()
                curr = curr.left
            }
        }
        result.reverse()
        return result
    }

    fun postorderTraversal2(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        // If the root is null, return an empty list
        if (root == null) return result

        var curr = root

        // Create a dummy node to simplify edge cases
        val dummyNode = TreeNode(-1)
        var predecessor: TreeNode? = null
        dummyNode.left = curr
        curr = dummyNode

        // Traverse the tree
        while (curr != null) {
            // If the current node has a left child
            if (curr.left != null) {
                predecessor = curr.left

                // Find the rightmost node in the left subtree or the thread to the current node
                while (predecessor!!.right != null && predecessor.right !== curr) {
                    predecessor = predecessor.right
                }

                // Create a thread if it doesn't exist
                if (predecessor.right == null) {
                    predecessor.right = curr
                    curr = curr.left
                } else {
                    // Process the nodes in the left subtree
                    var node = predecessor
                    reverseSubtreeLinks(curr.left, predecessor)

                    // Add nodes from right to left
                    while (node !== curr.left) {
                        result.add(node!!.`val`)
                        node = node.right
                    }
                    result.add(node!!.`val`) // Add root.left value
                    reverseSubtreeLinks(predecessor, curr.left)
                    predecessor.right = null
                    curr = curr.right
                }
            } else {
                // Move to the right child if there's no left child
                curr = curr.right
            }
        }

        return result
    }

    private fun reverseSubtreeLinks(startNode: TreeNode?, endNode: TreeNode?) {
        if (startNode === endNode) {
            return  // If the start and end nodes are the same, no need to reverse
        }

        var prev: TreeNode? = null
        var current = startNode
        var next: TreeNode? = null

        // Reverse the direction of the pointers in the subtree
        while (current !== endNode) {
            next = current!!.right
            current.right = prev
            prev = current
            current = next
        }
        // Reverse the last node
        current!!.right = prev
    }
}