package com.sk.set26


class Solution2610 {
    fun findMatrix(nums: IntArray): List<List<Int>> {
        val countMap: MutableMap<Int, Int> = HashMap()
        for(i in nums) {
            countMap[i] = countMap.getOrDefault(i, 0) + 1
        }

        val max = countMap.values.max()

        val ans = mutableListOf<MutableList<Int>>()
        repeat(max) { ans.add(mutableListOf<Int>()) }

        val map: MutableMap<Int, Int> = HashMap()
        for(i in nums) {
            map[i] = map.getOrDefault(i, 0) + 1
            ans[map[i]!! % countMap[i]!!].add(i)
        }

        return ans
    }

    fun findMatrix2(nums: IntArray): List<MutableList<Int>> {
        val res = ArrayList<MutableList<Int>>()
        val count = IntArray(nums.size + 1)
        for (a in nums) {
            if (res.size < ++count[a]) {
                res.add(ArrayList())
            }
            res[count[a]-1].add(a)
        }
        return res
    }
}