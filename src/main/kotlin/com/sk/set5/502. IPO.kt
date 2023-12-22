package com.sk.set5

import java.util.*


class Solution {
    fun findMaximizedCapital(
        k: Int, w: Int, profits: IntArray, capital: IntArray
    ): Int {
        var c = k
        var w = w
        while (c-- > 0) {
            // Select eligible business
            val eligibleBusiness = mutableListOf<Int>()
            for (i in capital.indices) {
                if (capital[i] == Int.MAX_VALUE) continue
                if (capital[i] <= w) eligibleBusiness.add(i)
            }

            var max = 0
            var selection = -1
            for (i in eligibleBusiness) {
                if (profits[i] == 0) continue
                if (profits[i] > max) {
                    max = profits[i]
                    selection = i
                }
            }
            if (selection != -1) {
                w += max //add profit
                capital[selection] = Int.MAX_VALUE
                profits[selection] = 0
            }
        }

        return w
    }

    fun findMaximizedCapital2(k: Int, W: Int, Profits: IntArray, Capital: IntArray): Int {
        var W = W
        val pqCap = PriorityQueue<IntArray> { a, b -> a[0] - b[0] } // min heap - capital
        val pqPro = PriorityQueue<IntArray> { a, b -> b[1] - a[1] } // max heap - profit
        for (i in Profits.indices) {
            pqCap.add(intArrayOf(Capital[i], Profits[i]))
        }
        for (i in 0 until k) {
            while (!pqCap.isEmpty() && pqCap.peek()[0] <= W) {
                pqPro.add(pqCap.poll())
            }
            if (pqPro.isEmpty()) break
            W += pqPro.poll()[1]
        }
        return W
    }
}