package com.sk.set4

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

    /*
        Maintain overlapping regions with (start, end)
        For every new element check whether does it overlap with other regions, update boundry of all of them.
        Return no of regions at last.
        We can sort the array first to improve time.
    */
    fun findMinArrowShots(points: Array<IntArray>): Int {
        points.sortBy { it[0] }
        var result = 0
        var regionX = points[0][0]
        var regionY = points[0][1]
        for (i in 1 until points.size) {
            if (isOverlap(regionX, regionY, points[i][0], points[i][1])) {
                regionX = maxOf(regionX, points[1][0])
                regionY = minOf(regionY, points[i][1])
            } else {
                result++
                regionX = points[i][0]
                regionY = points[i][1]
            }
        }
        return result + 1 // we update arrow count when found new region, for last region add 1 as there is not new region after last
    }

    private fun isOverlap(
        regionX: Int,
        regionY: Int,
        x: Int,
        y: Int
    ): Boolean { // check start only as array is sorted by start.
        return x in regionX..regionY
    }
}
