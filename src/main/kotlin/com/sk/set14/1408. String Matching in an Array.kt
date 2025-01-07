package com.sk.set14

class Solution1408 {
    fun stringMatching(words: Array<String>): List<String> {
        // Sort words by length (shorter words first)
        val sortedWords = words.sortedBy { it.length }
        val result = mutableListOf<String>()

        for (i in sortedWords.indices) {
            for (j in i + 1 until sortedWords.size) {
                // Check if sortedWords[i] is a substring of sortedWords[j]
                if (sortedWords[j].contains(sortedWords[i])) {
                    result.add(sortedWords[i])
                    break // Avoid duplicate checks for the same word
                }
            }
        }

        return result
    }
}