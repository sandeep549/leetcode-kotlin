package com.sk.set1

class Solution127 {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val seen = mutableSetOf<String>()

        val q = ArrayDeque<String>()
        q.add(beginWord)
        var ladder = 1
        while (q.isNotEmpty()) {
            var size = q.size
            while (size-- > 0) {
                val start = q.removeFirst()
                for (end in wordList) {
                    if (seen.contains(end)) continue
                    if (distance(start, end) == 1) {
                        seen.add(end)
                        if (end == endWord) return ladder + 1
                        q.add(end)
                    }
                }
            }
            ladder++
        }

        return 0
    }

    private fun distance(start: String, end: String): Int {
        var c = 0
        for (i in start.indices) {
            if (start[i] != end[i]) c++
            if (c == 2) return c
        }
        return c
    }


    /**
     * TC: O(n * m * 26) = O(n * m)
     * SC: O(n)
     * n: No of words in list
     * m: Size of each word
     */
    fun ladderLength2(beginWord: String, endWord: String, wordList: List<String>): Int {
        val dict = wordList.toMutableSet() // Contains words yet to visit
        val q = ArrayDeque<String>() // Contains next step of words to traverse
        q.add(beginWord)
        var ladder = 1
        while (q.isNotEmpty()) {
            var size = q.size
            while (size-- > 0) {
                val start = q.removeFirst().toCharArray()
                for (i in start.indices) {
                    val old = start[i]
                    for (c in 'a'..'z') {
                        start[i] = c
                        val end = String(start)
                        if (dict.contains(end)) {
                            if (end == endWord) {
                                return ladder + 1
                            }
                            q.add(end)
                            dict.remove(end)
                        }
                    }
                    start[i] = old
                }
            }
            ladder++
        }
        return 0
    }
}