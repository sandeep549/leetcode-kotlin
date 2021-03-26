package leetcode.kotlin.array.easy

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

/*

 */