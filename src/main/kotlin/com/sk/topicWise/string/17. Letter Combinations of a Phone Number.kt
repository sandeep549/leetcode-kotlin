package com.sk.topicWise.string

class Solution17 {
    fun letterCombinations(digits: String): List<String> {
        val map = mapOf(
            2 to listOf('a', 'b', 'c'),
            3 to listOf('d', 'e', 'f'),
            4 to listOf('g', 'h', 'i'),
            5 to listOf('j', 'k', 'l'),
            6 to listOf('m', 'n', 'o'),
            7 to listOf('p', 'q', 'r', 's'),
            8 to listOf('t', 'u', 'v'),
            9 to listOf('w', 'x', 'y', 'z')
        )

        val res = mutableListOf<String>()
        if (digits.isNotEmpty()) {
            dfs(0, StringBuilder(), digits, res, map)
        }
        return res
    }

    private fun dfs(idx: Int, str: StringBuilder, digits: String, res: MutableList<String>, map: Map<Int, List<Char>>) {
        if (idx == digits.length) {
            res.add(str.toString())
            return
        }
        val value = digits[idx].digitToInt()
        for (ch in map[value]!!) {
            dfs(idx + 1, StringBuilder(str).append(ch), digits, res, map)
        }
    }

    fun letterCombinations2(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()
        val map = mapOf(
            2 to listOf('a', 'b', 'c'),
            3 to listOf('d', 'e', 'f'),
            4 to listOf('g', 'h', 'i'),
            5 to listOf('j', 'k', 'l'),
            6 to listOf('m', 'n', 'o'),
            7 to listOf('p', 'q', 'r', 's'),
            8 to listOf('t', 'u', 'v'),
            9 to listOf('w', 'x', 'y', 'z')
        )

        val q = ArrayDeque<String>()
        q.addLast("")
        for (i in digits.indices) {
            val d = digits[i].digitToInt()
            while (q.first().length == i) {
                val s = q.removeFirst()
                for (ch in map[d]!!) {
                    q.addLast("$s$ch")
                }
            }
        }

        return q.toList()
    }
}

