package com.sk.leetcode.kotlin

private fun isPowerOfTwo(n: Int): Boolean {
    return if (n <= 0) false else (n and n - 1 == 0)
}