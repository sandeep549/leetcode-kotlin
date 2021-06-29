package leetcode.kotlin

import java.util.HashMap
import java.util.HashSet
import java.util.LinkedList
import java.util.Stack

//region - solution-1
private fun merge(intervals: Array<IntArray>): Array<IntArray> {
    if (intervals.isEmpty()) return emptyArray()
    val sortedIntervalList = intervals.sortedWith(Comparator { t1, t2 -> t1[0] - t2[0] })
    val result = ArrayList<IntArray>()
    for (i in 0..sortedIntervalList.lastIndex) {
        if (i == 0) {
            result.add(sortedIntervalList[i])
            continue
        }
        val curr = sortedIntervalList[i]
        val pre = result.last()
        if (curr[0] <= pre[1]) pre[1] = maxOf(pre[1], curr[1])
        else result.add(curr)
    }
    return result.toTypedArray()
}
//endregion

//region-Solution-2
private class Solution {
    private var graph = mutableMapOf<IntArray, MutableList<IntArray>>()
    private var nodesInComp = mutableMapOf<Int, MutableList<IntArray>>()
    private var visited = mutableSetOf<IntArray>()

    // return whether two intervals overlap (inclusive)
    private fun overlap(a: IntArray, b: IntArray): Boolean {
        return a[0] <= b[1] && b[0] <= a[1]
    }

    // build a graph where an undirected edge between intervals u and v exists
    // iff u and v overlap.
    private fun buildGraph(intervals: Array<IntArray>) {
        graph.clear()
        nodesInComp.clear()
        visited.clear()
        for (interval in intervals) {
            graph[interval] = LinkedList()
        }
        for (interval1 in intervals) {
            for (interval2 in intervals) {
                if (overlap(interval1, interval2)) {
                    graph[interval1]?.add(interval2)
                    graph[interval2]?.add(interval1)
                }
            }
        }
    }

    // merges all of the nodes in this connected component into one interval.
    private fun mergeNodes(nodes: List<IntArray>): IntArray {
        val min: Int = nodes.minBy { ints -> ints[0] }?.get(0) ?: 0
        val max: Int = nodes.maxBy { ints -> ints[1] }?.get(1) ?: 0
        return intArrayOf(min, max)
    }

    // use depth-first search to mark all nodes in the same connected component
    // with the same integer.
    private fun markComponentDFS(start: IntArray, compNumber: Int) {
        val stack = Stack<IntArray>()
        stack.add(start)
        while (!stack.isEmpty()) {
            val node = stack.pop()
            if (!visited.contains(node)) {
                visited.add(node)
                if (nodesInComp[compNumber] == null) {
                    nodesInComp[compNumber] = LinkedList()
                }
                nodesInComp[compNumber]?.add(node)
                graph[node]?.forEach { stack.add(it) }
            }
        }
    }

    // gets the connected components of the interval overlap graph.
    private fun buildComponents(intervals: Array<IntArray>) {
        nodesInComp = HashMap()
        visited = HashSet()
        var compNumber = 0
        for (interval in intervals) {
            if (!visited.contains(interval)) {
                markComponentDFS(interval, compNumber)
                compNumber++
            }
        }
    }

    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        buildGraph(intervals)
        buildComponents(intervals)

        // for each component, merge all intervals into one interval.
        val merged: MutableList<IntArray> = LinkedList()
        for (element in nodesInComp.values) {
            merged.add(mergeNodes(element))
        }
        return merged.toTypedArray()
    }
}
//endregion

//region - similar question
/**
 * https://leetcode.com/problems/meeting-rooms/
 */
//endregion
