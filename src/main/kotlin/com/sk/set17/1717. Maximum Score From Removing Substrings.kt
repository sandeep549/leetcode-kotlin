package com.sk.set17


class Solution1717 {
    fun maximumGain(s: String, x: Int, y: Int): Int {
        val (highPriorityPair, lowPriorityPair) = if (x > y) Pair("ab", "ba") else Pair("ba", "ab")

        // First pass: remove high priority pair
        val stringAfterFirstPass = removeSubstring(s, highPriorityPair)
        var removedPairsCount = (s.length - stringAfterFirstPass.length) / 2

        // Calculate score from first pass
        var totalScore = removedPairsCount * maxOf(x, y)

        // Second pass: remove low priority pair
        val stringAfterSecondPass = removeSubstring(stringAfterFirstPass, lowPriorityPair)
        removedPairsCount = (stringAfterFirstPass.length - stringAfterSecondPass.length) / 2

        // Calculate score from second pass
        totalScore += (removedPairsCount * minOf(x, y))

        return totalScore
    }

    private fun removeSubstring(input: String, targetPair: String): String {
        val charStack = ArrayDeque<Char>()

        // Iterate through each character in the input string
        for (element in input) {
            // Check if current character forms the target pair with the top of the stack
            if (element == targetPair[1] && !charStack.isEmpty() && charStack.last() == targetPair[0]
            ) {
                charStack.removeLast() // Remove the matching character from the stack
            } else {
                charStack.addLast(element)
            }
        }
        return charStack.joinTo(StringBuilder(), separator = "").reversed().toString()
    }
}