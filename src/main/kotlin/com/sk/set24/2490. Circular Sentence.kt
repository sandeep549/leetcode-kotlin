package com.sk.set24

class Solution2490 {
    fun isCircularSentence(sentence: String): Boolean {
        val words = sentence.split(" ")
        words.forEachIndexed { index, word ->
            if (index != words.lastIndex && word.last() != words[index + 1].first()) {
                return false
            }
        }
        return words.first().first() == words.last().last()
    }

    fun isCircularSentence2(sentence: String): Boolean {
        for (i in sentence.indices) {
            if (sentence[i] == ' ') {
                if (sentence[i - 1] != sentence[i + 1]) {
                    return false
                }
            }
        }
        return sentence[0] == sentence[sentence.lastIndex]
    }
}