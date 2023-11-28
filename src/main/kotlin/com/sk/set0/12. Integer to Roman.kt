package com.sk.set0

class Solution12 {
    fun intToRoman(num: Int): String {
        var n = num
        var sb = StringBuilder()
        while (n > 0) {
            when {
                n >= 1000 -> {
                    sb.append("M")
                    n -= 1000
                }

                n >= 500 -> {
                    if (n >= 900) {
                        sb.append("CM")
                        n -= 900
                    } else {
                        sb.append("D")
                        n -= 500
                    }
                }

                n >= 100 -> {
                    if (n >= 400) {
                        sb.append("CD")
                        n -= 400
                    } else {
                        sb.append("C")
                        n -= 100
                    }

                }

                n >= 50 -> {
                    if (n >= 90) {
                        sb.append("XC")
                        n -= 90
                    } else {
                        sb.append("L")
                        n -= 50
                    }

                }

                n >= 10 -> {
                    if (n >= 40) {
                        sb.append("XL")
                        n -= 40
                    } else {
                        sb.append("X")
                        n -= 10
                    }

                }

                n >= 5 -> {
                    if (n >= 9) {
                        sb.append("IX")
                        n -= 9
                    } else {
                        sb.append("V")
                        n -= 5
                    }

                }

                n >= 1 -> {
                    if (n >= 4) {
                        sb.append("IV")
                        n -= 4
                    } else {
                        sb.append("I")
                        n -= 1
                    }

                }
            }
        }
        return sb.toString()
    }

    fun intToRoman2(num: Int): String {
        var num = num
        val res = StringBuilder()
        val sym = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
        val values = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
        var i = 0
        while (num != 0) {
            while (num >= values[i]) {
                num -= values[i]
                res.append(sym[i])
            }
            i++
        }
        return res.toString()
    }

    fun intToRoman3(num: Int): String? {
        val M = arrayOf("", "M", "MM", "MMM")
        val C = arrayOf("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM")
        val X = arrayOf("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC")
        val I = arrayOf("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX")
        return M[num / 1000] + C[num % 1000 / 100] + X[num % 100 / 10] + I[num % 10]
    }
}