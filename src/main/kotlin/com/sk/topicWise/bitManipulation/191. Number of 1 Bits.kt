package com.sk.topicWise.bitManipulation

//fun main() {
//    println(hammingWeight(-2147483648))
//}

class Solution191 {
    fun hammingWeight(n: Int): Int {
        var num = n
        var count = 0
        while (num != 0) {
            if (num and 1 == 1) count++
            num = num ushr 1
        }
        return count
    }

    fun hammingWeight2(n: Int): Int {
        var num = n
        var count = 0
        while (num != 0) {
            count++
            num = num and (num-1) // drop leftmost bit
        }
        return count
    }
}
