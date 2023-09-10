package com.sk.leetcode.google

import com.sk.topicWise.tree.TreeNode

private fun findLeaves(root: TreeNode?): List<List<Int>> {
    val map = sortedMapOf<Int, MutableList<Int>>(comparator = Comparator { t1, t2 -> t2-t1 })
    dfs(root, map)
    return map.values.toList()
}

private fun dfs(root: TreeNode?, map: MutableMap<Int, MutableList<Int>>): Int {
    if(root == null) return 0
    val l = dfs(root.left, map)
    val r = dfs(root.right, map)
    val rank = maxOf(l, r)
    val list = map.getOrDefault(rank, mutableListOf<Int>())
    list.add(root.`val`)
    map[rank] = list
    return rank
}


private fun findLeaves2(root: TreeNode?): List<List<Int>> {
    val map = sortedMapOf<Int, MutableList<Int>>()
    dfs(root, map)
    return map.values.toList().reversed()
}

private fun dfs2(root: TreeNode?, map: MutableMap<Int, MutableList<Int>>): Int {
    if(root == null) return 0
    val l = dfs(root.left, map)
    val r = dfs(root.right, map)
    val rank = maxOf(l, r)
    val list = map.getOrDefault(rank, mutableListOf<Int>())
    list.add(root.`val`)
    map[rank] = list
    return rank
}