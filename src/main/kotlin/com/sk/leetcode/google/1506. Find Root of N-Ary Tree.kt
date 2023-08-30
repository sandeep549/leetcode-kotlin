package com.sk.leetcode.google

class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}

//####################################################################

class Solution1506_1 {

    fun findRoot(tree: List<Node>): Node? {
        val seen = HashSet<Node?>()
        tree.forEach { seen.addAll(it.children) }
        return tree.find { seen.contains(it).not() }
    }

}
//####################################################################

class Solution1506_2 {

    fun findRoot(tree: List<Node>): Node? {
        var sum = 0
        for (node in tree) {
            sum += node.`val`
            for (child in node.children)
                sum -= child!!.`val`
        }

        var root: Node? = null
        for (node in tree) {
            if (node.`val` == sum) {
                root = node
                break
            }
        }
        return root
    }
}
