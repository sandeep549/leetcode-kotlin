package com.sk.topicWise.slidingwindow.hard


class Solution30 {

    // Time: O(N*W) ; N is size of s, and W is no of words
    // Space: O(W)
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val counts = HashMap<String, Int>()
        for (word in words) {
            counts[word] = counts.getOrDefault(word, 0) + 1
        }
        val indexes = ArrayList<Int>()
        val n = s.length
        val num = words.size
        val len = words[0].length
        for (i in 0 until n - num * len + 1) {
            val seen = HashMap<String, Int>()
            var j = 0
            while (j < num) {
                val word = s.substring(i + j * len, i + (j + 1) * len)
                if (counts.containsKey(word)) {
                    seen[word] = seen.getOrDefault(word, 0) + 1
                    if (seen[word]!! > counts.getOrDefault(word, 0)) {
                        break
                    }
                } else {
                    break
                }
                j++
            }
            if (j == num) {
                indexes.add(i)
            }
        }
        return indexes
    }
}