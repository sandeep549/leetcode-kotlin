package com.sk.set8

class Solution846 {
    fun isNStraightHand(hand: IntArray, groupSize: Int): Boolean {
        val N = hand.size
        if (N % groupSize != 0) return false

        val cardCountMap = sortedMapOf<Int, Int>()
        for (i in 0 until N) {
            cardCountMap[hand[i]] = cardCountMap.getOrDefault(hand[i], 0) + 1
        }

        while (cardCountMap.size > 0) {
            val currentCard = cardCountMap.entries.iterator().next().key
            for (i in 0 until groupSize) {
                if (!cardCountMap.containsKey(currentCard + i)) return false
                cardCountMap[currentCard + i] = cardCountMap[currentCard + i]!! - 1
                if (cardCountMap[currentCard + i] == 0) cardCountMap.remove(currentCard + i)
            }
        }
        return true
    }
}