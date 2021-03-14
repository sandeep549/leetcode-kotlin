package leetcode.kotlin.array.easy

private fun slowestKey(releaseTimes: IntArray, keysPressed: String): Char {
    val n = releaseTimes.size
    var maxDifference = releaseTimes[0]
    var bestChar = keysPressed[0]
    for (i in 1 until n) {
        val difference = releaseTimes[i] - releaseTimes[i - 1]
        if (difference > maxDifference ||
            difference == maxDifference && keysPressed[i] > bestChar
        ) {
            maxDifference = difference
            bestChar = keysPressed[i]
        }
    }
    return bestChar
}