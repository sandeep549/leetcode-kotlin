package com.sk.leetcode.kotlin

class Solution9 {
    fun isPalindrome(x: Int): Boolean {
        return x.toString() == x.toString().reversed()
    }

    fun isPalindrome2(x: Int): Boolean {
        var n = x
        if (n < 0) return false
        var rev = 0
        while (n > 0) {
            rev = rev * 10 + n % 10
            n /= 10
        }
        return x == rev
    }
}

fun main() {
    val s = Solution9()
    println(s.isPalindrome2(121))
}