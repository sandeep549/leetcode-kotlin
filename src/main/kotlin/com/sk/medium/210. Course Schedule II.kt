package com.sk.medium


class Solution210 {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val list = ArrayList<ArrayList<Int>>()
        for (i in 0 until numCourses) {
            list.add(ArrayList())
        }

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

        val path = ArrayList<Int>()
        while (!queue.isEmpty()) {
            val course = queue.removeFirst()
            path.add(course)
            count++
            for (preC in list[course]) {
                // We have completed this course, decrement prerequisite count by 1 for all adjacent nodes
                if (--indegree[preC] == 0) { // This course has 0 prerequisite now and can be started
                    queue.addLast(preC)
                }
            }
        }

        return if (count == numCourses) path.toIntArray() else intArrayOf()
    }
}