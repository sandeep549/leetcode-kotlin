package com.sk.set16

class Solution1662 {

    // https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/solutions/967572/java-4-pointers-and-iterator-solution-doing-it-in-o-1-space-is-the-trick/?envType=daily-question&envId=2023-12-01
    fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
        var p1 = 0
        var p2 = 0 // inner pointer

        var w1 = 0
        var w2 = 0 // outer pointer


        while (w1 < word1.size && w2 < word2.size) {
            val curr1 = word1[w1]
            val curr2 = word2[w2]
            if (curr1[p1] != curr2[p2]) return false
            if (p1 < curr1.length - 1) {
                p1++
            } else {
                p1 = 0
                w1++
            }
            if (p2 < curr2.length - 1) {
                p2++
            } else {
                p2 = 0
                w2++
            }
        }

        return w1 == word1.size && w2 == word2.size
    }
}