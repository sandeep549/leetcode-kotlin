package com.sk.topicWise.dp.hard


class Solution1335 {

    fun minDifficulty(jobDifficulty: IntArray, days: Int): Int {
        val SIZE = jobDifficulty.size
        if (SIZE < days) return -1

        fun minAt(startIndex: Int, d: Int): Int {
            if (d == 0 && startIndex == SIZE) return 0
            if (d == 0 || startIndex == SIZE) return Int.MAX_VALUE
            var curMax = jobDifficulty[startIndex]
            var min = Int.MAX_VALUE
            for (i in startIndex until SIZE) {
                curMax = maxOf(curMax, jobDifficulty[i])
                val temp = minAt(i + 1, d - 1)
                if (temp != Int.MAX_VALUE) min = minOf(min, temp + curMax)
            }
            return min
        }

        return minAt(0, days)
    }

    fun minDifficulty2(jobDifficulty: IntArray, days: Int): Int {
        val SIZE = jobDifficulty.size
        if (SIZE < days) return -1
        val memo = Array(SIZE) { IntArray(days + 1) { -1 } }

        fun minAt(startIndex: Int, d: Int): Int {
            if (d == 0 && startIndex == SIZE) return 0
            if (d == 0 || startIndex == SIZE) return Int.MAX_VALUE
            if (memo[startIndex][d] == -1) {
                var curMax = jobDifficulty[startIndex]
                var min = Int.MAX_VALUE
                for (i in startIndex until SIZE) {
                    curMax = maxOf(curMax, jobDifficulty[i])
                    val temp = minAt(i + 1, d - 1)
                    if (temp != Int.MAX_VALUE) min = minOf(min, temp + curMax)
                }
                memo[startIndex][d] = min
            }
            return memo[startIndex][d]
        }

        return minAt(0, days)
    }

    fun minDifficulty3(jobDifficulty: IntArray, d: Int): Int {
        val A = Array(jobDifficulty.size) { IntArray(d) { Int.MAX_VALUE } }
        A[0][0] = jobDifficulty[0]
        for (i in 1 until jobDifficulty.size) {
            A[i][0] = maxOf(A[i - 1][0], jobDifficulty[i])
        }
        for (i in 1 until jobDifficulty.size) {
            for (j in 1 until minOf(i + 1, d)) {
                for (k in 0 until i) {
                    A[i][j] = minOf(A[i][j], A[k][j - 1] + jobDifficulty.sliceArray(k + 1..i + 1).maxOrNull()!!)
                }
            }
        }
        return A.last().last()
    }

}


fun main() {
    val s = Solution1335()
    println(s.minDifficulty2(intArrayOf(6, 5, 4, 3, 2, 1), 2))
}