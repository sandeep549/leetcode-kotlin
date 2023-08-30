package com.sk

private fun findMinArrowShots(points: Array<IntArray>): Int {
    if (points.isEmpty()) return 0
    val sortedPoints =
        points.sortedWith(
            Comparator { o1, o2 ->
                if (o1[0] < o2[0]) -1
                else if (o1[0] == o2[0]) 0
                else 1
            }
        )
    var count = 1
    var i = sortedPoints[0][0]
    var j = sortedPoints[0][1]
    sortedPoints.forEach { println(it.toList()) }
    for (k in 1..sortedPoints.lastIndex) {
        val ballon = sortedPoints[k]
        if (j < ballon[0]) {
            count++
            i = ballon[0]
            j = ballon[1]
        } else {
            i = maxOf(i, ballon[0])
            j = minOf(j, ballon[0])
        }
    }
    return count
}

//###############################################################################
//
//###############################################################################
class Solution452 {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        points.sortBy { it[0] }
        var result = 0
        var p = Pair(points[0][0], points[0][1])
        for (i in 1 until points.size) {
            if (isOverlap(p, points[i][0], points[i][1])) {
                p = Pair(
                    maxOf(p.first, points[1][0]),
                    minOf(p.second, points[i][1])
                )
            } else {
                result++
                p = Pair(points[i][0], points[i][1])
            }
        }
        return result + 1 // we update arrow count when found new region, for last region add 1 as there is not new regionafter last
    }

    fun isOverlap(
        p: Pair<Int, Int>,
        x: Int,
        y: Int
    ): Boolean { // check start only as array is sorted by start.
        return x >= p.first && x <= p.second
    }
}

/*
Maintain overlapping regions with (start, end)
For every new element check whether does it overlap with other regions, update boundry of all of them.
Return no of regions at last.

We can sort the array first to improve time.
 */