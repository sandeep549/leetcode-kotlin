package com.sk.topicWise.string.easy

private fun isPrefixOfWord(sentence: String, searchWord: String): Int {
    val arr = sentence.split(" ")
    for (i in arr.indices) {
        if (arr[i].startsWith(searchWord)) return i + 1
    }
    return -1
}
