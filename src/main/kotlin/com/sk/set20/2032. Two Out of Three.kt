package com.sk.set20

class Solution2032 {
    fun twoOutOfThree(
        nums1: IntArray, nums2: IntArray, nums3: IntArray
    ): List<Int> {
        val list = mutableListOf<Set<Int>>()
        list += nums1.toSet()
        list += nums2.toSet()
        list += nums3.toSet()
        val ans = mutableSetOf<Int>()
        for(i in list.indices) {
            val set = list[i]
            for(item in set) {
                for(k in i+1..list.lastIndex) {
                    if(list[k].contains(item)) {
                        ans += item
                        break
                    }
                }
            }
        }
        return ans.toList()
    }

    fun twoOutOfThree2(
        nums1: IntArray, nums2: IntArray, nums3: IntArray
    ): List<Int> {
        val arr = Array(3) { IntArray(101) { 0 } }
        for (i in nums1) arr[0][i] = 1
        for (i in nums2) arr[1][i] = 1
        for (i in nums3) arr[2][i] = 1

        val ans = mutableListOf<Int>()
        for (i in 1..100) {
            if (arr[0][i] + arr[1][i] + arr[2][i] >= 2) ans.add(i)
        }

        return ans
    }
}