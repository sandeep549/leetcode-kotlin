package com.sk.medium

import java.util.LinkedList
import java.util.Stack

class Solution56 {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.isEmpty()) return emptyArray()
        intervals.sortBy { it[0] } // sort with start time
        val result = ArrayList<IntArray>()
        for (i in intervals.indices) {
            val curr = intervals[i]
            if (i == 0) {
                result.add(curr)
                continue
            }
            val pre = result.last()
            if (curr[0] <= pre[1]) { // Is curr start overlap with previous interval?
                pre[1] = maxOf(pre[1], curr[1])
            } else { // Its start of new interval
                result.add(curr)
            }
        }
        return result.toTypedArray()
    }
}

// ================================================================================================

//region-Solution-2
private class Solution2 {
    private var graph = HashMap<IntArray, MutableList<IntArray>>()
    private var nodesInComp = HashMap<Int, MutableList<IntArray>>()
    private var visited = HashSet<IntArray>()

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

    // merges all the nodes in this connected component into one interval.
    private fun mergeNodes(nodes: List<IntArray>): IntArray {
        val min: Int = nodes.minBy { ints -> ints[0] }[0] ?: 0
        val max: Int = nodes.maxBy { ints -> ints[1] }[1] ?: 0
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
