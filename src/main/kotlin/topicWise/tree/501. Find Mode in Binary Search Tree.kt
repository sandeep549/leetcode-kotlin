package topicWise.tree

import java.util.ArrayDeque

private fun findMode(root: TreeNode?): IntArray {
    if (root == null) return intArrayOf()
    val map = hashMapOf<Int, Int>() // HashMap<Int, Int>()
    fun dfs(root: TreeNode?) {
        root?.let {
            map.put(it.`val`, map.getOrDefault(it.`val`, 0) + 1)
            dfs(it.left)
            dfs(it.right)
        }
    }
    dfs(root)
    val maxValue = map.maxBy { it.value }!!.value
    val maxEntries = map.filterValues { it == maxValue }
    return maxEntries.keys.toIntArray()
}

/**
 * Traverse tree in inorder, have a feel like traversing an increasing array, mark down the max frequency found so far
 * and their elements in a list.
 * Single traversal
 * O(n)
 * O(1); if we do not consider recursion stack space and output data structure to hols result to return, O(n) otherwise
 */
private fun findMode2(root: TreeNode?): IntArray {
    if (root == null) return intArrayOf()
    var pre: Int? = null
    var count = -1
    var maxSoFar = 0
    val ans = ArrayList<Int>()
    fun checkValue(item: Int) {
        if (item == pre) {
            if (++count == maxSoFar) {
                ans.add(item)
            } else if (count > maxSoFar) {
                ans.clear()
                ans.add(item)
            }
            pre = item
            maxSoFar = maxOf(maxSoFar, count)
        } else {
            pre = item
            count = 1
            if (count >= maxSoFar) ans.add(item)
        }
    }

    fun dfs(root: TreeNode?) {
        root?.let {
            dfs(it.left)
            checkValue(it.`val`)
            dfs(it.right)
        }
    }
    dfs(root)
    return ans.toIntArray()
}

private fun findMode3(root: TreeNode?): IntArray {
    if (root == null) return intArrayOf()
    var pre: Int? = null
    var count = -1
    var maxSoFar = 0
    val ans = ArrayList<Int>()
    fun checkValue(item: Int) {
        if (item == pre) {
            if (++count == maxSoFar) {
                ans.add(item)
            } else if (count > maxSoFar) {
                ans.clear()
                ans.add(item)
            }
            pre = item
            maxSoFar = maxOf(maxSoFar, count)
        } else {
            pre = item
            count = 1
            if (count >= maxSoFar) ans.add(item)
        }
    }

    val stack = ArrayDeque<TreeNode>()
    var curr = root
    while (curr != null || !stack.isEmpty()) {
        while (curr != null) {
            stack.push(curr)
            curr = curr.left
        }
        curr = stack.pop()
        checkValue(curr.`val`)
        curr = curr.right
    }
    return ans.toIntArray()
}
