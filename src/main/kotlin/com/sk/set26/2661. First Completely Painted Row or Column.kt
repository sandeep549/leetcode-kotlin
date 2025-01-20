package com.sk.set26

class Solution2661 {
    fun firstCompleteIndex(arr: IntArray, mat: Array<IntArray>): Int {
        val m = mat.size
        val n = mat[0].size

        val intToCellMap = mutableMapOf<Int, Cell>()

        for (r in mat.indices) {
            for(c in mat[0].indices) {
                intToCellMap[mat[r][c]] = Cell(r, c)
            }
        }

        val rowArr = IntArray(m)
        val colArr = IntArray(n)
        for ((index, loc) in arr.withIndex()) {
            val cell = intToCellMap[loc]!!
            rowArr[cell.r]++
            colArr[cell.c]++
            if (rowArr[cell.r] == n || colArr[cell.c] == m) {
                return index
            }
        }

        return -1
    }

    data class Cell(val r: Int, val c: Int)
}