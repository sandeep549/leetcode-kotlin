package com.sk.leetcode.kotlin

private fun generate(numRows: Int): List<List<Int>> {
    val list = ArrayList<List<Int>>()
    for (row in 1..numRows) {
        val currow = ArrayList<Int>()
        for (item in 1..row) {
            if (item == 1 || item == row) {
                currow.add(1)
            } else {
                currow.add(list.get(row - 2).get(item - 2) + list.get(row - 2).get(item - 1))
            }
        }
        list.add(currow)
    }
    return list
}


private fun generate2(numRows: Int): List<List<Int>> {
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
