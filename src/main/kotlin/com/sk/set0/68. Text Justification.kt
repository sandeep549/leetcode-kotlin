package com.sk.set0

import java.lang.StringBuilder

class Solution68 {
    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        val res = mutableListOf<String>()
        var i = 0
        while (i < words.size) {
            var charLen = 0
            var j = i
            charLen += words[j].length
            var spaces = 0
            while (j < words.size - 1 && (charLen + spaces + 1 + words[j + 1].length) <= maxWidth) { // we can accommodate next word
                j++ // Include this word
                spaces++ // Increase space count
                charLen += words[j].length // Increase char length
            }
            //println("Line no ${res.size+1}")
            //println("charLen=$charLen, spaces=$spaces")
            var extraSpace = maxWidth - charLen - spaces
            var spaceSize = if (spaces > 0) 1 else 0
            while (j + 1 < words.size && spaces > 0 && extraSpace >= spaces) {
                spaceSize++
                extraSpace -= spaces
            }
            //println("spaceSize=$spaceSize, extraSpace=$extraSpace")

            // fill [i-j] words into this line
            if (j + 1 < words.size) { // Not last line
                val sb = StringBuilder()
                for (k in i..j) {
                    sb.append(words[k])
                    if (k != j) { // No space after last word
                        repeat(spaceSize) { sb.append(" ") }
                        if (extraSpace > 0) {
                            sb.append(" ")
                            extraSpace--
                        }
                    }
                }
                //println(sb.toString())
                while (extraSpace > 0) {
                    sb.append(" ")
                    extraSpace--
                }
                res.add(sb.toString())
            } else { // Last line left justified
                val sb = StringBuilder()
                for (k in i..j) {
                    sb.append(words[k])
                    if (k != j) sb.append(" ")
                }
                //println(sb.toString())
                while (extraSpace > 0) {
                    sb.append(" ")
                    extraSpace--
                }
                res.add(sb.toString())
            }

            // println(res)
            i = j + 1
        }
        return res
    }
}

fun main() {
    val s = Solution68()
    val arr = arrayOf("This", "is", "an", "example", "of", "text", "justification.")
    val arr2 = arrayOf("What", "must", "be", "acknowledgment", "shall", "be")

    s.fullJustify(arr2, 16).forEach {
        println(it)
    }
}