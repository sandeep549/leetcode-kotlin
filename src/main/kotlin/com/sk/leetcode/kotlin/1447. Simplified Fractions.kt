package com.sk.leetcode.kotlin

private fun simplifiedFractions2(n: Int): List<String> {
    val res = mutableListOf<String>()
    val set = mutableSetOf<Double>()
    for (i in 1 until n) {
        for (j in i + 1..n) {
            if (!set.contains(i.toDouble() / j)) {
                res.add("$i/$j")
                set.add(i.toDouble() / j)
            }
        }
    }
    return res
}

private fun simplifiedFractions(n: Int): List<String>? {
    fun gcd(x: Int, y: Int): Int {
        return if (x == 0) y else gcd(y % x, x)
    }

    val ans = mutableListOf<String>()
    for (denominator in 2..n) {
        for (numerator in 1 until denominator) {
            if (gcd(numerator, denominator) == 1) {
                ans.add("$numerator/$denominator")
            }
        }
    }
    return ans
}
