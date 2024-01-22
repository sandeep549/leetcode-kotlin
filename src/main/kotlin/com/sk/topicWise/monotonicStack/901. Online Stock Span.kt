package com.sk.topicWise.monotonicStack

class StockSpanner901() {
    val stack = ArrayDeque<Pair<Int, Int>>()

    fun next(price: Int): Int {
        var count = 1
        while (stack.isNotEmpty() && stack.last().first <= price) {
            count += stack.removeLast().second
        }
        stack.addLast(Pair(price, count))
        return count
    }

}