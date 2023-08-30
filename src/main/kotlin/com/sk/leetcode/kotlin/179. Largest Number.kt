package com.sk.leetcode.kotlin

private fun largestNumber(nums: IntArray): String {
    val arr = nums.map { it.toString() } // to string array
    val res =
        arr.sortedWith(kotlin.Comparator { o1, o2 -> (o2 + o1).compareTo(o1 + o2) }) // sort it
    if (res[0] == "0") return "0"
    return res.fold(StringBuilder(), { acc, i -> acc.append(i) }).toString() // fold it
}