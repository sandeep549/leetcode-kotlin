package com.sk

private class SolutionMatchingSubsequencies {
    fun numMatchingSubseq(s: String, words: Array<String>): Int {
        class Sequence(var index: Int, val word: String)

        val map = mutableMapOf<Char, MutableSet<Sequence>>()
        words.forEach { word ->
            val set = map.getOrDefault(word[0], mutableSetOf())
            set.add(Sequence(0, word))
            map.put(word[0], set)
        }

        var count = 0
        for (c in s) {
            val waiting = map[c]
            map.remove(c)
            if (waiting != null && waiting.size > 0) {
                for (sq in waiting) {
                    if (sq.index == sq.word.length - 1) {
                        count++
                    } else {
                        sq.index
                        val set = map.getOrDefault(sq.word[++sq.index], mutableSetOf())
                        set.add(sq)
                        map[sq.word[sq.index]] = set
                    }
                }
            }
        }

        return count
    }
}