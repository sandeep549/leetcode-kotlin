package com.sk.set22

import java.util.*
import kotlin.collections.HashMap


class Solution2225 {
    fun findWinners(matches: Array<IntArray>): List<List<Int>> {
        val winners = mutableSetOf<Int>()
        val losers = mutableMapOf<Int, Int>()
        for (match in matches) {
            val winner = match[0]
            val loser = match[1]
            losers[loser] = losers.getOrDefault(loser, 0) + 1
            if (!losers.containsKey(winner)) {
                winners.add(winner)
            }
            if (winners.contains(loser)) {
                winners.remove(loser)
            }
        }

        val ans = mutableListOf<MutableList<Int>>()
        ans.add(winners.toMutableList().also { it.sort() })
        ans.add(losers.filter { it.value == 1 }.keys.toMutableList().also { it.sort() })
        return ans
    }

    fun findWinners2(matches: Array<IntArray>): List<List<Int>> {
        val losses: MutableMap<Int, Int> = HashMap()
        for (m in matches) {
            losses[m[0]] = losses.getOrDefault(m[0], 0)
            losses[m[1]] = losses.getOrDefault(m[1], 0) + 1
        }

        val ans = mutableListOf<MutableList<Int>>()
        val winners = mutableListOf<Int>()
        val one = mutableListOf<Int>()
        for ((k, v) in losses) {
            if (v == 0) winners.add(k)
            if (v == 1) one.add(k)
        }
        winners.sort()
        one.sort()
        ans.add(winners)
        ans.add(one)
        return ans
    }
}