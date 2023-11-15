package com.sk.hard

class Solution135 {
    fun candy(ratings: IntArray): Int {
        val candies = IntArray(ratings.size) { 1 }
        for (i in 1..ratings.lastIndex) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1
            }
        }
        println(candies.toList())
        for (i in ratings.lastIndex - 1 downTo 0) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = maxOf(candies[i], candies[i + 1] + 1)
            }
        }
        println(candies.toList())
        return candies.sum()
    }

    fun candy2(ratings: IntArray): Int {
        val candies = IntArray(ratings.size) { 1 } // Give 1 candy to each child, condition-1
        var l = 1
        var r = ratings.lastIndex - 1
        while (l <= ratings.lastIndex) {
            if (ratings[l] > ratings[l - 1]) {
                candies[l] = maxOf(candies[l], candies[l - 1] + 1) // Give 1 extra candy compared to left child
            }
            if (ratings[r] > ratings[r + 1]) {
                candies[r] = maxOf(candies[r], candies[r + 1] + 1) // Give 1 extra candy compared to right child
            }
            l++
            r--
        }
        return candies.sum()
    }
}