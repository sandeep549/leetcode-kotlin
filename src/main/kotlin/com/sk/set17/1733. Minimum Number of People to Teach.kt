package com.sk.set17


class Solution1733 {
    // https://leetcode.com/problems/minimum-number-of-people-to-teach/solutions/1031079/python-3-steps
    fun minimumTeachings(n: Int, languages: Array<IntArray>, friendships: Array<IntArray>): Int {
        var ans = 0
        val dontspeak = HashSet<Int>()
        for (f in friendships) {
            val u = f[0] - 1
            val v = f[1] - 1
            val set1 = languages[u].toMutableSet()
            val set2 = languages[v].toMutableSet()
            set1.retainAll(set2) // set1 intersection set2
            if (set1.size == 0) { // this means there is no common element between set1 and set2
                dontspeak.add(u)
                dontspeak.add(v)
            }
        }
        val freq = IntArray(n + 1)
        for (idx in dontspeak) { //counting frequency of languages spoke
            for (ele in languages[idx]) freq[ele]++
        }

        val max = freq.max() // finding popular language frequency
        ans = dontspeak.size - max
        return ans
    }
}