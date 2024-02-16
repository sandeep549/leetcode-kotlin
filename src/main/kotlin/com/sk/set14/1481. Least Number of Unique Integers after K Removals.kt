package com.sk.set14


class Solution1481 {
    fun findLeastNumOfUniqueInts(arr: IntArray, k: Int): Int {
        var k = k
        val map = HashMap<Int, Int>()
        for (a in arr) {
            map[a] = map.getOrDefault(a, 0) + 1
        }

        val bucket = Array(arr.size + 1) { ArrayList<Int>() }
        for ((key, value) in map) {
            bucket[value].add(key)
        }
        var count = map.size
        var i = 0
        while (i < bucket.size && k > 0) {
            if (bucket[i].isEmpty()) {
                i++
                continue
            }
            if (k - bucket[i].size * i >= 0) {
                k -= bucket[i].size * i
                count -= bucket[i].size
            } else {
                count -= k / i
                break
            }
            i++
        }
        return count
    }
}