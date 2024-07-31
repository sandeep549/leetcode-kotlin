package com.sk.set11


class Solution1105 {

    fun minHeightShelves(books: Array<IntArray>, shelfWidth: Int): Int {
        val dp = IntArray(books.size+1)
        dp[0] = 0
        for (i in 1..books.size) {
            var width = books[i - 1][0]
            var height = books[i - 1][1]
            dp[i] = dp[i - 1] + height
            var j = i - 2
            while (j >= 0 && width + books[j][0] <= shelfWidth) {
                width += books[j][0]
                height = maxOf(height, books[j][1])
                dp[i] = minOf(dp[i], (dp[j] + height))
                j--
            }
        }
        return dp[books.size]
    }
}