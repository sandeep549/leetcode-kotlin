package com.sk.set28

class Solution2800 {
    fun minimumString(a: String, b: String, c: String): String {
        fun merge(s1: String, s2: String): String {
            if (s1.contains(s2)) return s1
            if (s2.contains(s1)) return s2
            for (i in s1.length downTo 1) {
                if (s2.startsWith(s1.substring(s1.length - i))) {
                    return s1 + s2.substring(i)
                }
            }
            return s1 + s2
        }

        val permutations = listOf(
            listOf(a, b, c),
            listOf(a, c, b),
            listOf(b, a, c),
            listOf(b, c, a),
            listOf(c, a, b),
            listOf(c, b, a)
        )

        var result: String? = null

        for (perm in permutations) {
            val firstMerge = merge(perm[0], perm[1])
            val finalMerge = merge(firstMerge, perm[2])

            if (result == null || finalMerge.length < result.length ||
                (finalMerge.length == result.length && finalMerge < result)) {
                result = finalMerge
            }
        }

        return result ?: ""
    }
}
