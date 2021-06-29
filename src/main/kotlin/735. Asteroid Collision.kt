package leetcode.kotlin.array.medium

import kotlin.math.abs

private fun asteroidCollision(asteroids: IntArray): IntArray {
    val list = mutableListOf<Int>()
    var i = 0
    var cur = 0
    while (i < asteroids.size) {
        cur = asteroids[i]
        if (cur < 0) {
            if (list.isEmpty() || list[list.lastIndex] < 0) {
                list.add(cur)
            } else {
                while (cur != 0 && list.isNotEmpty() && list[list.lastIndex] > 0) {
                    if (abs(cur) > list[list.lastIndex]) {
                        list.removeAt(list.lastIndex) // previous destroyed
                    } else if (abs(asteroids[i]) < list[list.lastIndex]) {
                        cur = 0 // current asteriod destroyed
                    } else {
                        list.removeAt(list.lastIndex) // both destroyed
                        cur = 0
                    }
                }
                if (cur != 0) list.add(asteroids[i])
            }
        } else {
            list.add(asteroids[i])
        }
        i++
    }
    return list.toIntArray()
}