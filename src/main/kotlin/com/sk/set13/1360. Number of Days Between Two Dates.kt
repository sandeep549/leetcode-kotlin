package com.sk.set13

import kotlin.math.abs

class Solution1360 {
    fun daysBetweenDates(date1: String, date2: String): Int {
        return abs(calcDaysFrom1971(date1) - calcDaysFrom1971(date2))
    }

    private val daysOfMonth = intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    private fun calcDaysFrom1971(date: String): Int {
        val dateArr = date.split("-".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val y = dateArr[0].toInt()
        val m = dateArr[1].toInt()
        var d = dateArr[2].toInt()
        for (iy in 1971 until y) d += if (isLeap(iy)) 366 else 365
        for (i in 0 until m - 1) d += daysOfMonth[i]
        if (m > 2 && isLeap(y)) d += 1 // on Feb leap year have 29 days instead of 28
        return d
    }

    private fun isLeap(year: Int): Boolean {
        return year % 400 == 0 || year % 100 != 0 && year % 4 == 0
    }
}