package com.sk.topicWise.tree.easy

import java.util.*


class Solution1394 {
    fun findLucky(arr: IntArray): Int {
        val map = TreeMap<Int, Int>(Collections.reverseOrder())
        for (key in arr) {
            map[key] = map.getOrDefault(key, 0) + 1
        }

        for ((k, v) in map) {
            if (k == v) return k
        }

        return -1
    }

    fun findLucky2(arr: IntArray): Int {
        val a = IntArray(501)
        for (e in arr) {
            a[e]++
        }
        for (i in a.indices.reversed()) {
            if (a[i] == i && i != 0) return i
        }
        return -1
    }
}