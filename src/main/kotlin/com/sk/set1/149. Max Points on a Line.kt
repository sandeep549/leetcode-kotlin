package com.sk.set1


class Solution149 {

    // ???
    fun maxPoints(points: Array<IntArray>): Int {
        fun slope(a: IntArray, b: IntArray): Double {
            return (b[1].toDouble() - a[1]) / (b[0] - a[0])
        }

        val map = HashMap<Double, MutableSet<Pair<Int, Int>>>()

        for (i in points.indices) {
            for (j in i + 1 until points.size) {
                val s = slope(points[i], points[j])
                val set = map.getOrDefault(s, mutableSetOf())
                set.add(Pair(points[i][0], points[i][1]))
                set.add(Pair(points[j][0], points[j][1]))
                map[s] = set
            }
        }

        return if (map.values.isNotEmpty()) map.values.maxOf { it.size } else 0
    }

    /**
     * Solution taken from here https://leetcode.com/problems/max-points-on-a-line/solutions/47113/a-java-solution-with-notes
     * Algorithm:
     * Consider every point and all other points to the right of it.
     * Find slope(i.e. dy/dx, where dy=y2-y1 and dx=x2-x1) of these 2 points.
     * Store slope count in map. As starting point is same for all slopes, there can not be parallel line having same slope.
     * Keep track of max slope count.
     * Return max.
     *
     * Why +1: We are never adding starting point to count, so add it last to simplify the calculation.
     * Why GCD: Slope 10/6 is equal to 5/3, read this topic to get this https://en.wikipedia.org/wiki/Irreducible_fraction
     *
     */
    fun maxPoints2(points: Array<IntArray>): Int {
        if (points.size <= 2) return points.size
        val map = HashMap<String, Int>()
        var max = 0
        for (i in points.indices) {
            map.clear()
            for (j in i + 1 until points.size) {
                var x = points[j][0] - points[i][0]
                var y = points[j][1] - points[i][1]

                val gcd = generateGCD(x, y)
                if (gcd != 0) {
                    x /= gcd
                    y /= gcd
                }
                val key = "$y/$x"
                map[key] = map.getOrDefault(key, 0) + 1
                max = maxOf(max, map[key]!!)
            }
        }
        return max + 1
    }

    private fun generateGCD(a: Int, b: Int): Int {
        return if (b == 0) a else generateGCD(b, a % b)
    }

    // why this is faster than maxPoints2 ???
    fun maxPoints3(points: Array<IntArray>): Int {
        var maxCount = 1
        for (i in 0 until points.size) {
            for (j in i + 1 until points.size) {
                var count = 2
                for (k in j + 1 until points.size) {
                    if (points[k].isColliniar(points[i], points[j])) {
                        count++
                    }
                }
                if (maxCount < count) {
                    maxCount = count
                }
            }
        }
        return maxCount
    }

    // https://byjus.com/maths/collinearity-of-three-points/
    private fun IntArray.isColliniar(x: IntArray, y: IntArray): Boolean {
        val x1 = x[0]
        val y1 = x[1]
        val x2 = y[0]
        val y2 = y[1]
        val x3 = this[0]
        val y3 = this[1]

        return y3 * (x2 - x1) - x3 * (y2 - y1) == y1 * (x2 - x1) - (y2 - y1) * x1
    }
}


