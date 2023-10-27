package com.sk.topicWise.tree.easy

import com.sk.topicWise.tree.TreeNode
import java.util.*


class Solution226 {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        val left = root.left
        val right = root.right
        root.left = invertTree(right)
        root.right = invertTree(left)
        return root
    }

    fun invertTree2(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }

        val stack: Deque<TreeNode> = LinkedList()
        stack.push(root)

        while (!stack.isEmpty()) {
            val node = stack.pop()
            val left = node.left
            node.left = node.right
            node.right = left
            if (node.left != null) {
                stack.push(node.left)
            }
            if (node.right != null) {
                stack.push(node.right)
            }
        }
        return root
    }

    fun invertTree3(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }

        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(root)

        while (!queue.isEmpty()) {
            val node = queue.poll()
            val left = node.left
            node.left = node.right
            node.right = left
            if (node.left != null) {
                queue.offer(node.left)
            }
            if (node.right != null) {
                queue.offer(node.right)
            }
        }
        return root
    }
}