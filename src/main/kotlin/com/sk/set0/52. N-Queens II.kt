package com.sk.set0


class Solution52 {
    fun totalNQueens(n: Int): Int {
        val occupiedCols: MutableSet<Int> = HashSet()
        val occupiedDiag1s: MutableSet<Int> = HashSet()
        val occupiedDiag2s: MutableSet<Int> = HashSet()

        return totalNQueensHelper(0, 0, n, occupiedCols, occupiedDiag1s, occupiedDiag2s)
    }

    private fun totalNQueensHelper(
        row: Int,
        count: Int,
        n: Int,
        occupiedCols: MutableSet<Int>,
        occupiedDiag1s: MutableSet<Int>,
        occupiedDiag2s: MutableSet<Int>
    ): Int {
        var c = count
        for (col in 0 until n) {
            if (occupiedCols.contains(col)) continue
            val diag1 = row - col
            if (occupiedDiag1s.contains(diag1)) continue
            val diag2 = row + col
            if (occupiedDiag2s.contains(diag2)) continue
            // we can now place a queen here
            if (row == n - 1) c++ else {
                occupiedCols.add(col)
                occupiedDiag1s.add(diag1)
                occupiedDiag2s.add(diag2)
                c = totalNQueensHelper(row + 1, c, n, occupiedCols, occupiedDiag1s, occupiedDiag2s)
                // recover
                occupiedCols.remove(col)
                occupiedDiag1s.remove(diag1)
                occupiedDiag2s.remove(diag2)
            }
        }
        return c
    }
}