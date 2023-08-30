package com.sk.topicWise.string.easy

class Solution520 {
    fun detectCapitalUse(word: String): Boolean {
        var capital = 0
        for (c in word.toCharArray()) {
            if ('Z' - c >= 0) {
                capital++
            }
        }
        return capital == 0 || // all small case
                capital == word.length || // all capital letter
                capital == 1 && 'Z' - word[0] >= 0 // onyl first letter is capital
    }
}