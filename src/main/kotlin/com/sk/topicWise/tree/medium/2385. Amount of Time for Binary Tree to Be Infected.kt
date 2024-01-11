package com.sk.topicWise.tree.medium

import com.sk.topicWise.tree.TreeNode
import kotlin.collections.ArrayDeque
import kotlin.collections.HashMap

class Solution2385 {

    fun amountOfTime(root: TreeNode?, start: Int): Int {
        var amount = 0

        // if subtree does not contain infected node, return maximum depth
        // if subtree contains infected node, return infected node depth (use negative value to distinguish this case)
        fun traverse(root: TreeNode?, start: Int): Int {
            if (root == null) {
                return 0
            }
            val left = traverse(root.left, start)
            val right = traverse(root.right, start)
            return if (root.`val` == start) {
                // we are at the initially infected node
                // use maximum subtree depth as the initial amount value
                amount = maxOf(left, right)
                -1
            } else if (left >= 0 && right >= 0) {
                // this subtree does not contain infected node
                // return maximum subtree depth for further calculations
                maxOf(left, right) + 1
            } else {
                // one of the subtrees contains initially infected node
                // sum depth of initially infected node (negative value) and max depth of the other subtree (positive value)
                amount = maxOf(amount, Math.abs(left - right))
                minOf(left, right) - 1
            }
        }

        traverse(root, start)
        return amount
    }


    fun amountOfTime2(root: TreeNode?, start: Int): Int {
        val adjMap = HashMap<Int, MutableList<Int>>() //adjacency list

        fun createGraph(root: TreeNode?, parent: Int) {
            if (root == null) return
            val child = root.`val`
            if (parent != -1) {
                adjMap.getOrPut(parent) { mutableListOf() }.add(child)
                adjMap.getOrPut(child) { mutableListOf() }.add(parent)
            }
            createGraph(root.left, child)
            createGraph(root.right, child)
        }

        createGraph(root, -1)

        val queue = ArrayDeque<Int>()
        queue.add(start)
        val seen = HashSet<Int>()
        seen.add(start)
        var time = 0
        while (queue.isNotEmpty()) {
            var n = queue.size
            while (n-- > 0) {
                val node = queue.removeFirst()
                adjMap[node]?.forEach { neighbour ->
                    if (!seen.contains(neighbour)) {
                        queue.add(neighbour)
                        seen.add(neighbour)
                    }
                }
// why below code section throw error on LC ?
//                for (neighbour in adjMap[node]!!) {
//                    if (!seen.contains(neighbour)) {
//                        queue.add(neighbour)
//                        seen.add(neighbour)
//                    }
//                }
            }
            time++
        }

        return time - 1
    }
}

fun main() {
    val s = Solution2385()

    val root = TreeNode(1)
    root.left = TreeNode(5)
    root.left!!.right = TreeNode(4)
    root.left!!.right!!.left = TreeNode(9)
    root.left!!.right!!.right = TreeNode(2)

    root.right = TreeNode(3)
    root.right!!.left = TreeNode(10)
    root.right!!.right = TreeNode(6)


    println(s.amountOfTime2(root, 3))
}