package com.sk

class Solution2244 {
    fun minimumRounds(tasks: IntArray): Int {
        val freq: MutableMap<Int, Int> = HashMap()
        // Store the frequencies in the map.
        for (task in tasks) {
            freq[task] = freq.getOrDefault(task, 0) + 1
        }
        var minimumRounds = 0
        // Iterate over the task's frequencies.
        for (count in freq.values) {
            // If the frequency is 1, it's not possible to complete tasks.
            if (count == 1) {
                return -1
            }
            minimumRounds += if (count % 3 == 0) {
                // Group all the task in triplets.
                count / 3
            } else {
                // If count % 3 = 1; (count / 3 - 1) groups of triplets and 2 pairs.
                // If count % 3 = 2; (count / 3) groups of triplets and 1 pair.
                count / 3 + 1
            }
        }
        return minimumRounds
    }
}
