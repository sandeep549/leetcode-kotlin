package com.sk.set9

import com.sk.topicWise.dp.wordBreak3

class Solution916 {
    fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
        val maxFreq = IntArray(26) // To store max frequency of each character in words2

        // Build the max frequency map for words2
        for (word in words2) {
            val tempFreq = IntArray(26)
            for (char in word) {
                tempFreq[char - 'a']++
            }
            for (i in 0..25) {
                maxFreq[i] = maxOf(maxFreq[i], tempFreq[i])
            }
        }

        val result = mutableListOf<String>()

        // Check each word in words1 against the max frequency map
        for (word in words1) {
            val wordFreq = IntArray(26)
            for (char in word) {
                wordFreq[char - 'a']++
            }
            var isUniversal = true
            for (i in 0..25) {
                if (wordFreq[i] < maxFreq[i]) {
                    isUniversal = false
                    break
                }
            }
            if (isUniversal) {
                result.add(word)
            }
        }

        return result
    }
}