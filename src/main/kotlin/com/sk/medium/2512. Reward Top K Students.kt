package com.sk.medium

class Solution2512 {
    fun topStudents(
        positive_feedback: Array<String>,
        negative_feedback: Array<String>,
        reports: Array<String>,
        student_id: IntArray,
        k: Int
    ): List<Int> {
        val positive = positive_feedback.toSet()
        val negative = negative_feedback.toSet()

        val feedback = mutableMapOf<Int, Int>()

        for (i in reports.indices) {
            val report = reports[i]
            feedback[student_id[i]] = 0 // assign 0 to this student to handle edge case
            for (word in report.split(" ")) {
                when {
                    positive.contains(word) -> {
                        feedback[student_id[i]] = feedback[student_id[i]]!! + 3
                    }

                    negative.contains(word) -> {
                        feedback[student_id[i]] = feedback[student_id[i]]!! - 1
                    }
                }
            }
        }

        return feedback
            .toList()
            .sortedWith(compareByDescending<Pair<Int, Int>> { it.second }.thenBy { it.first })
            .take(k)
            .map { it.first }
    }
}