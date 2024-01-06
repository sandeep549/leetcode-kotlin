package com.sk.`todo-revise`

import java.util.*


class Solution1235 {

    // TLE
    fun jobScheduling(
        startTime: IntArray, endTime: IntArray, profit: IntArray
    ): Int {
        val jobs = Array(startTime.size) { IntArray(3) }
        for (i in startTime.indices) {
            jobs[i][0] = startTime[i]
            jobs[i][1] = endTime[i]
            jobs[i][2] = profit[i]
        }
        jobs.sortBy { it[0] }

        fun schedule(i: Int, curTime: Int, curProfit: Int): Int {
            var max = 0
            for (k in i..startTime.lastIndex) {
                if (jobs[k][0] >= curTime) {
                    max = maxOf(max, schedule(k + 1, jobs[k][1], jobs[k][2]))
                }
            }

            return curProfit + max
        }

        return schedule(0, 1, 0)
    }

    // TLE
    fun jobScheduling2(
        startTime: IntArray, endTime: IntArray, profit: IntArray
    ): Int {
        val jobs = Array(startTime.size) { IntArray(3) }
        for (i in startTime.indices) {
            jobs[i][0] = startTime[i]
            jobs[i][1] = endTime[i]
            jobs[i][2] = profit[i]
        }
        jobs.sortBy { it[0] }
        val dp = IntArray(startTime.size) { -1 }

        fun schedule(i: Int, curTime: Int, curProfit: Int): Int {
            if (i == startTime.size) return 0
            if (dp[i] == -1) {
                var max = 0
                for (k in i..startTime.lastIndex) {
                    if (jobs[k][0] >= curTime) {
                        max = maxOf(max, schedule(k + 1, jobs[k][1], jobs[k][2]))
                    }
                }
                dp[i] = curProfit + max
            }
            return dp[i]
        }

        return schedule(0, 1, 0)
    }

    // MLE
    fun jobScheduling3(
        startTime: IntArray, endTime: IntArray, profit: IntArray
    ): Int {
        val jobs = Array(startTime.size) { IntArray(3) }
        for (i in startTime.indices) {
            jobs[i][0] = startTime[i]
            jobs[i][1] = endTime[i]
            jobs[i][2] = profit[i]
        }
        jobs.sortBy { it[0] }

        class Job(val endTime: Int, val profit: Int)

        var runningList = mutableListOf<Job>()
        runningList.add(Job(0, 0))
        for (newJob in jobs) {
            val newList = mutableListOf<Job>()
            for (runningJob in runningList) {
                newList.add(runningJob) // don't start new job
                if (runningJob.endTime <= newJob[0]) { // start this new job
                    newList.add(Job(newJob[1], runningJob.profit + newJob[2]))
                }
            }
            runningList = newList
        }

        return runningList.maxOf { it.profit }
    }

    // https://leetcode.com/problems/maximum-profit-in-job-scheduling/solutions/409009/java-c-python-dp-solution
    fun jobScheduling4(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
        val n = startTime.size
        val jobs = Array(n) { IntArray(3) }
        for (i in 0 until n) {
            jobs[i] = intArrayOf(startTime[i], endTime[i], profit[i])
        }

        jobs.sortBy { it[1] } // sort by end time

        val dp = TreeMap<Int, Int>()  // max profit at any end time
        dp[0] = 0
        for (job in jobs) {
            val maxProfitHere = dp.floorEntry(job[0]).value + job[2]
            if (maxProfitHere > dp.lastEntry().value) dp[job[1]] = maxProfitHere
        }
        return dp.lastEntry().value
    }

}