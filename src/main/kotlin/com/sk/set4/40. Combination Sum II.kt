package com.sk.set4

class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        candidates.sort()
        backtrack(result, mutableListOf(), candidates, target, 0)
        return result
    }

    private fun backtrack(
        result: MutableList<List<Int>>,
        path: MutableList<Int>,
        candidates: IntArray,
        target: Int,
        index: Int
    ) {
        if (target < 0) {
            return
        } else if (target == 0) { // Add to the answer array, if the sum is equal to target.
            result.add(path.toList())
        } else {
            var start = index
            while (start < candidates.size && target >= candidates[start]) {
                if (start > index && candidates[start] == candidates[start - 1]) {
                    start++
                    continue
                }
                // Add it to tempList.
                path.add(candidates[start])
                // Check for all possible scenarios.
                backtrack(result, path, candidates, target - candidates[start], start + 1)
                // Backtrack the tempList.
                path.removeLast()
                start++
            }
        }
    }
}