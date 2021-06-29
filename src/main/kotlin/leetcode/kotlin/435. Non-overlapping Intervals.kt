package leetcode.kotlin.array

private fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
    val sortedIntervals = intervals.sortedWith(kotlin.Comparator { o1, o2 -> o1[0] - o2[0] })
    var count = 0
    var i = 0
    var j = 1
    while (i < sortedIntervals.size - 1) {
        if (j >= sortedIntervals.size) break
        if (sortedIntervals[i][1] > sortedIntervals[j][0]) { // overlap
            if (sortedIntervals[i][1] < sortedIntervals[j][1]) { // second's end is bigger, delete it
                j++ // delete j interval
            } else { // remove first one
                i = j // remove i interval
                j++
            }
            count++
        } else {
            i++
            j++
        }
    }
    return count
}