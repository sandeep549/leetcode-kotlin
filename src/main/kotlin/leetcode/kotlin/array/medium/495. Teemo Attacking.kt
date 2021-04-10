package leetcode.kotlin.array.medium

private fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
    if (timeSeries.isEmpty()) return 0
    var result = 0
    for (i in 0 until timeSeries.lastIndex) {
        result += minOf(duration, timeSeries[i + 1] - timeSeries[i])
    }
    result += duration
    return result
}