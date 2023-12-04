package com.sk.set0

class Solution46 {
    fun permute(nums: IntArray): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        dfs(nums, mutableSetOf(), ans)
        return ans
    }

    private fun dfs(nums: IntArray, set: MutableSet<Int>, ans: MutableList<List<Int>>) {
        if (set.size == nums.size) {
            ans.add(set.toList()) // make copy and add to answer
        } else {
            for (ele in nums) {
                if (set.contains(ele)) continue
                set.add(ele) // add
                dfs(nums, set, ans)
                set.remove(ele) // remove
            }
        }
    }

}

