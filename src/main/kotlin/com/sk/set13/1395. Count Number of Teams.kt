package com.sk.set13

class Solution1395 {

    fun numTeams(rating: IntArray): Int {
        var ans = 0
        for (i in 0 until rating.size) {
            for (j in i+1 until rating.size) {
                if (rating[j] < rating[i]) continue
                for (k in j+1 until rating.size) {
                    if (rating[k] > rating[j]) ans++
                }
            }
        }
        for (i in 0 until rating.size) {
            for (j in i+1 until rating.size) {
                if (rating[j] > rating[i]) continue
                for (k in j+1 until rating.size) {
                    if (rating[k] < rating[j]) ans++
                }
            }
        }
        return ans
    }

    // For each soldier, count how many soldiers on the left and right have less and greater ratings
    fun numTeams2(rating: IntArray): Int {
        var res = 0
        for (i in 1 until rating.size - 1) { // find less and greater for every i
            val less = IntArray(2)
            val greater = IntArray(2)
            for (j in rating.indices) {
                if (rating[j] > rating[i]) ++greater[if (j > i) 1 else 0]      // greater[0] is on left, greater[1] is on right
                if (rating[j] < rating[i]) ++less[if (j > i) 1 else 0]   // less[0] is on left, less[1] is on right
            }
            res += less[0] * greater[1] + greater[0] * less[1]
        }
        return res
    }
}