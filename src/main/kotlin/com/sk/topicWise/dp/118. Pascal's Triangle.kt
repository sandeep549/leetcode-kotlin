package com.sk.topicWise.dp

class Solution118 {
    fun generate(numRows: Int): List<List<Int>> {
        val res = mutableListOf<MutableList<Int>>()
        for (r in 0 until numRows) {
            val rowItems = mutableListOf<Int>()
            for (c in 0..r) {
                if (c == 0 || c == r) {
                    rowItems.add(1)
                    continue
                }
                val no = res[r - 1][c - 1] + res[r - 1][c]
                rowItems.add(no)
            }
            res.add(rowItems)
        }
        return res
    }
}

