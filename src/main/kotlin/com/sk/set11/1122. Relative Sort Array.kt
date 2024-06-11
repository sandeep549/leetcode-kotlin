package com.sk.set11

class Solution1122 {
    fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
        val valueToIndexMap = arr2.mapIndexed { index, value -> value to index }.toMap()
        return arr1.sortedWith { o1, o2 ->
            if (valueToIndexMap[o1] != null && valueToIndexMap[o2] != null) valueToIndexMap[o1]!! - valueToIndexMap[o2]!! // compare index of both
            else if (valueToIndexMap[o1] != null) -1 // o1 present so place it first
            else if (valueToIndexMap[o2] != null) 1 // o2 present, reverse order and place o2 it first
            else o1 - o2 // Both absent, compare them by value
        }.toIntArray()
    }

    fun relativeSortArray2(arr1: IntArray, arr2: IntArray): IntArray {
        val cnt = IntArray(1001)
        for (n in arr1) cnt[n]++
        var i = 0
        for (n in arr2) {
            while (cnt[n]-- > 0) {
                arr1[i++] = n
            }
        }
        for (n in cnt.indices) {
            while (cnt[n]-- > 0) {
                arr1[i++] = n
            }
        }
        return arr1
    }
}