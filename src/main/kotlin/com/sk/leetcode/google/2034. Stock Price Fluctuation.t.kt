package com.sk.leetcode.google

import java.util.TreeMap


private class StockPrice {
    var priceMap = TreeMap<Int, Int>() // price, value
    var valueMap = TreeMap<Int, MutableSet<Int>>() // value, time-set map

    fun update(timestamp: Int, price: Int) {
        if (priceMap.containsKey(timestamp)) {
            val prevPrice = priceMap[timestamp]!!
            val timeSet = valueMap[prevPrice]!!
            timeSet.remove(timestamp)
            if (timeSet.isEmpty()) {
                valueMap.remove(prevPrice)
            }
        }
        valueMap.putIfAbsent(price, HashSet())
        valueMap[price]!!.add(timestamp)
        priceMap[timestamp] = price
    }

    fun current(): Int {
        return priceMap.lastEntry().value
    }

    fun maximum(): Int {
        return valueMap.lastKey()
    }

    fun minimum(): Int {
        return valueMap.firstKey()
    }
}