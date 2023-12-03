package com.sk.set29


class Solution2952 {

    // Same as LC330
    fun minimumAddedCoins(coins: IntArray, target: Int): Int {
        coins.sort()
        var missing: Long = 1 // Why long, for edge case when n=2147483647
        var patches = 0
        var i = 0

        while (missing <= target) {
            if (i < coins.size && coins[i] <= missing) {
                missing += coins[i]
                i++
            } else {
                missing += missing
                patches++
            }
        }

        return patches
    }

    // https://leetcode.com/problems/minimum-number-of-coins-to-be-added/solutions/4356100/c-python-java-greedy-explained/comments/2155629

    fun minimumAddedCoins2(coins: IntArray, target: Int): Int {
        val map = HashMap<Int, Int>()
        for (coin in coins) {
            map[coin] = map.getOrDefault(coin, 0) + 1
        }
        var limit = 0
        var patch = 0
        var i = 1
        while (limit < target) {
            if (map.containsKey(i)) {
                limit += map[i]!! * i
            } else if (i > limit) {
                limit += i
                map[i] = 1
                patch++
            }
            i++
        }
        return patch
    }
}