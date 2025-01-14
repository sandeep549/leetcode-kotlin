package com.sk.set14

import java.util.*

class Solution1451 {
    fun arrangeWords(text: String): String {
        // Split the text into words
        val words = text.lowercase().split(" ")

        // Sort the words by length, maintaining original order for equal lengths
        val sortedWords = words.sortedBy { it.length }

        // Join the sorted words into a single string
        val result = sortedWords.joinToString(" ")

        // Capitalize the first character and make the rest lowercase
        return result.capitalize()
        //return result.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
    }
}