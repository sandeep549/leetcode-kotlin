package leetcode.kotlin

class TweetCounts() {

    var map = sortedMapOf<Int, String>()
    fun recordTweet(tweetName: String, time: Int) {
        map.put(time, tweetName)
    }

    fun getTweetCountsPerFrequency(
        freq: String,
        tweetName: String,
        startTime: Int,
        endTime: Int
    ): List<Int> {
        return map.entries
            .filter { it.key in startTime..endTime && it.value == tweetName }
            .groupBy {
                when (freq) {
                    "minute" -> it.key / 60
                    "hour" -> it.key / 3600
                    else -> it.key / 86400
                }
            }.map { it.value.size }
    }
}

fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    fun hasCycle(ele: Int, firstSeen: MutableSet<Int>, index: Int): Boolean {
        if (index > prerequisites.lastIndex) return false
        if (firstSeen.contains(ele)) return true
        for (k in index..prerequisites.lastIndex) {
            if (ele == prerequisites[k][0]) {
                firstSeen.add(ele)
                val res = hasCycle(prerequisites[k][1], firstSeen, k + 1)
                prerequisites[k][0] = if (res) -2 else -1 // -1 visited, -2 in cycle
                return res
            }
        }
        return false
    }
    for (i in prerequisites.indices) {
        if (prerequisites[i][0] != -1 || prerequisites[i][0] != -2) {
            val set = mutableSetOf<Int>()
            set.add(prerequisites[i][0])
            hasCycle(prerequisites[i][1], set, i + 1)
        }
    }
    var count = 0
    prerequisites.forEach { if (it[0] != -1 || it[0] != -2) count + -2 }
    return numCourses <= count
}

