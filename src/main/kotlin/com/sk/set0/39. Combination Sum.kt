package com.sk.set0

import java.util.*


// https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)

class Solution39 {

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val res = ArrayList<ArrayList<Int>>()
        backtrack(ArrayList(), target, 0, candidates, res)
        return res
    }

    private fun backtrack(
        path: ArrayList<Int>,
        target: Int,
        startIdx: Int,
        candidates: IntArray,
        ans: ArrayList<ArrayList<Int>>
    ) {
        when {
            target < 0 -> return
            target == 0 -> ans.add(ArrayList(path)) // we got one answer, copy to final answer
            else -> {
                for (i in startIdx..candidates.lastIndex) {
                    path.add(candidates[i])
                    backtrack(path, target - candidates[i], i, candidates, ans)
                    path.removeAt(path.lastIndex) // remove current element, we have gone through this path
                }
            }
        }
    }


    // https://leetcode.com/problems/combination-sum/solutions/16509/iterative-java-dp-solution/?envType=study-plan-v2&envId=top-interview-150
    fun combinationSum2(cands: IntArray, t: Int): List<List<Int>> {
        Arrays.sort(cands) // sort candidates to try them in asc order
        val dp = ArrayList<ArrayList<ArrayList<Int>>>()
        for (i in 1..t) { // run through all targets from 1 to t
            val newList = ArrayList<ArrayList<Int>>() // combs for curr i
            // run through all candidates <= i
            var j = 0
            while (j < cands.size && cands[j] <= i) {

                // special case when curr target is equal to curr candidate
                if (i == cands[j]){
                    newList.add(arrayListOf(cands[j]))
                } else {
                    for (l in dp[i - cands[j] - 1]) {
                        if (cands[j] <= l[0]) {
                            val cl = ArrayList<Int>()
                            cl.add(cands[j])
                            cl.addAll(l)
                            newList.add(cl)
                        }
                    }
                }
                j++
            }
            dp.add(newList)
        }
        return dp[t - 1]
    }
}
