package leetcode.kotlin.array.medium

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