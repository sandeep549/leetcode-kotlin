package com.sk.set7

import java.util.*


fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, K: Int): Int {
    var prices = IntArray(n) { Int.MAX_VALUE }
    prices[src] = 0
    for (i in 0..K) {
        val temp = Arrays.copyOf(prices, n)
        for ((cur, next, price) in flights) {
            if (prices[cur] == Int.MAX_VALUE) continue
            temp[next] = minOf(temp[next], prices[cur] + price)
        }
        prices = temp
    }
    return if (prices[dst] == Int.MAX_VALUE) -1 else prices[dst]
}