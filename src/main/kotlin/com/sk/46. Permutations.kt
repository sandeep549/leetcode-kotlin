package com.sk

private fun permute(nums: IntArray): List<List<Int>> {
    val ans = mutableListOf<List<Int>>()
    fun dfs(set: MutableSet<Int>) {
        if (set.size == nums.size) {
            ans.add(set.toList())
        } else {
            for (ele in nums) {
                if (set.contains(ele)) continue
                set.add(ele)
                dfs(set)
                set.remove(ele)
            }
        }
    }
    dfs(mutableSetOf())
    return ans
}
