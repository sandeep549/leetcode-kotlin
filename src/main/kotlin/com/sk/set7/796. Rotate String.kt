package com.sk.set7

class Solution796 {
    fun rotateString(s: String?, goal: String?): Boolean {
        if (s == null || goal == null) {
            //throw exception on A and B both being null?
            return false
        }
        if (s.length != goal.length) {
            return false
        }
        if (s.isEmpty()) {
            return true
        }
        for (i in s.indices) {
            if (rotateString(s, goal, i)) {
                return true
            }
        }
        return false
    }

    private fun rotateString(s: String, goal: String, rotation: Int): Boolean {
        for (i in s.indices) {
            if (s[i] != goal[(i + rotation) % goal.length]) {
                return false
            }
        }
        return true
    }
}