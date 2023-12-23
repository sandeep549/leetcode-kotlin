package com.sk.set14

class Solution {
    fun isPathCrossing(path: String): Boolean {
        var x = 0
        var y = 0
        val seen = mutableSetOf<Pair<Int, Int>>()
        for (ch in path) {
            when (ch) {
                'N' -> {
                    y++
                }

                'S' -> {
                    y--
                }

                'E' -> {
                    x++
                }

                'W' -> {
                    x--
                }
            }
            val loc = Pair(x, y)
            if (!seen.add(loc)) return true
        }
        return false
    }
}