package com.sk.medium

import java.util.*
import kotlin.collections.ArrayDeque


class Solution207 {
    /**
     * Simulate course complete simulation, if all course covered, we are good, return false otherwise.
     *
     * If u is prerequisite for course v, then create graph with edge u->v.
     * We shall first start with u (prerequisite) and then finish main course.
     * Maintain in-degree of all nodes. If a node has 0 in-degree, means we can start from that course.
     *
     * Why in-degree?, we want to simulate course simulation and want to start where we don't have prerequisite.
     *
     * In-degree represent prerequisite course counts for that course(node)
     */
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val list = ArrayList<ArrayList<Int>>()
        for (i in 0 until numCourses) list.add(ArrayList())
        val indegree = IntArray(numCourses)
        for (pre in prerequisites) {
            list[pre[1]].add(pre[0])
            indegree[pre[0]]++
        }
        var count = 0
        val queue = ArrayDeque<Int>()
        for (i in indegree.indices) {
            if (indegree[i] == 0) queue.addLast(i)
        }
        while (!queue.isEmpty()) {
            val course = queue.removeFirst()
            count++
            for (preC in list[course]) {
                // We have completed this course, decrement prerequisite count by 1 for all adjacent nodes
                if (--indegree[preC] == 0) { // This course has 0 prerequisite now and can be started
                    queue.addLast(preC)
                }
            }
        }
        return count == numCourses
    }
}