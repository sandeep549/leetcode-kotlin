package com.sk.set6

class Solution {
    fun replaceWords(dictionary: List<String>, sentence: String): String {
        val dict = dictionary.sortedBy { it }
        val sb = StringBuilder()
        val line = sentence.split(" ")
        loop@ for (word in line) {
            for (root in dict) {
                if (word.startsWith(root)) {
                    sb.append(" ")
                    sb.append(root)
                    continue@loop
                }
            }
            sb.append(" ")
            sb.append(word)
        }
        return sb.trim().toString()
    }
}