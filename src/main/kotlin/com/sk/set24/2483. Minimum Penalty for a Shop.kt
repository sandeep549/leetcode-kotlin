package com.sk.set24

class Solution2483 {
    fun bestClosingTime(customers: String): Int {
        val penaltyRight = IntArray(customers.length + 1)

        for (i in customers.indices.reversed()) {
            if (customers[i] == 'Y') {
                penaltyRight[i] = penaltyRight[i+1] + 1
            } else {
                penaltyRight[i] = penaltyRight[i+1]
            }
        }

        var penaltyLeft = 0
        var minClosing = 0
        var minPenalty = 0
        for (i in customers.indices) {

            if (customers[i] == 'N') {
                penaltyLeft++
            }
        }

    }
}