package com.sk.set14

class Solution1482 {
    fun minDays(bloomDay: IntArray, M: Int, K: Int): Int {
        var l = bloomDay.min()
        var r = bloomDay.max()
        while (l < r) {
            val m = l + (r - l) / 2
            val bouquets = bouquetsAtDay(m, bloomDay, M, K)
            if (bouquets < M) {
                l = m + 1
            } else {
                r = m
            }
        }
        return if (bouquetsAtDay(l, bloomDay, M, K) >= M) l else -1
    }

    private fun bouquetsAtDay(today: Int, bloomDay: IntArray, M: Int, K: Int): Int {
        var continuous = 0
        var bouquets = 0
        for (bday in bloomDay) {
            if (bday <= today) {
                continuous++
            } else {
                continuous = 0
            }
            if (continuous == K) {
                bouquets++
                continuous = 0
            }
        }
        return bouquets
    }
}