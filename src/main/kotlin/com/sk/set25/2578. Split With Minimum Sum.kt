package com.sk.set25

class Solution2578 {
    fun splitNum(num: Int): Int {
        // Convert the number to a string, split it into characters, and sort them
        val sortedDigits = num.toString().toCharArray().sorted()

        // Create two numbers by alternating digits
        val num1 = StringBuilder()
        val num2 = StringBuilder()
        for ((index, digit) in sortedDigits.withIndex()) {
            if (index % 2 == 0) {
                num1.append(digit)
            } else {
                num2.append(digit)
            }
        }

        // Convert the strings to integers, add them, and return the result
        Integer.valueOf(num1.toString())
        return (num1.toString().toInt() + num2.toString().toInt())
    }
}