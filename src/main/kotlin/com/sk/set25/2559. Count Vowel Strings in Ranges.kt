package com.sk.set25

class Solution2559 {
    fun vowelStrings(words: Array<String>, queries: Array<IntArray>): IntArray {
        val vowels = setOf('a', 'e', 'i', 'o', 'u')

        // Precompute cumulative sums for words starting and ending with vowels
        val cumSum = IntArray(words.size)
        for (i in words.indices) {
            cumSum[i] = cumSum.getOrElse(i - 1) { 0 } +
                    if (words[i].first() in vowels && words[i].last() in vowels) 1 else 0
        }

        // Process each query
        return queries.map { (l, r) ->
            cumSum[r] - (cumSum.getOrElse(l - 1) { 0 })
        }.toIntArray()
    }
}
