package com.sk.topicWise.graph

class Solution2709 {

    private val prime2index = HashMap<Int, MutableList<Int>>()
    private val index2prime = HashMap<Int, MutableList<Int>>()
    private fun dfs(index: Int, visitedIndex: BooleanArray, visitedPrime: MutableMap<Int?, Boolean>) {
        if (visitedIndex[index]) return
        visitedIndex[index] = true
        if (index2prime[index] == null) return
        for (prime in index2prime[index]!!) {
            if (visitedPrime.getOrDefault(prime, false)) continue
            visitedPrime[prime] = true
            for (index1 in prime2index[prime]!!) {
                if (visitedIndex[index1]) continue
                dfs(index1, visitedIndex, visitedPrime)
            }
        }
    }

    fun canTraverseAllPairs(nums: IntArray): Boolean {
        for (i in nums.indices) {
            var temp = nums[i]
            var j = 2
            while (j * j <= nums[i]) {
                if (temp % j == 0) {
                    prime2index.computeIfAbsent(j) { ArrayList() }.add(i)
                    index2prime.computeIfAbsent(i) { ArrayList() }.add(j)
                    while (temp % j == 0) {
                        temp /= j
                    }
                }
                j++
            }
            if (temp > 1) {
                prime2index.computeIfAbsent(temp) { ArrayList() }.add(i)
                index2prime.computeIfAbsent(i) { ArrayList() }.add(temp)
            }
        }
        val visitedIndex = BooleanArray(nums.size)
        val visitedPrime: MutableMap<Int?, Boolean> = HashMap()
        dfs(0, visitedIndex, visitedPrime)

        for (b in visitedIndex) {
            if (!b) return false
        }

        return true
    }
}

