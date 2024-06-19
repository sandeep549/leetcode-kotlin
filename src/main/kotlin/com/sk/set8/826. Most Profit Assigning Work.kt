package com.sk.set8

class Solution {
    fun maxProfitAssignment(difficulty: IntArray, profit: IntArray, worker: IntArray): Int {
        val jobs = mutableListOf<Pair<Int, Int>>()
        for (j in profit.indices) {
            jobs.add(Pair(difficulty[j], profit[j]))
        }

        jobs.sortBy { it.first }
        worker.sort()

        var res = 0
        var best = 0
        var i = 0
        for (ability in worker) {
            while (i < jobs.size && ability >= jobs[i].first) {
                best = maxOf(jobs[i].second, best)
                i++
            }
            res += best
        }
        return res
    }


}