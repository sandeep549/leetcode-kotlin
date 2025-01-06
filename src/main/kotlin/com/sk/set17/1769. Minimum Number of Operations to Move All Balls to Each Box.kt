package com.sk.set17

class Solution1769 {
    fun minOperations(boxes: String): IntArray {
        val totalMoves = IntArray(boxes.length)
        var ones = 0
        var moves = 0
        for (i in boxes.indices.reversed()) {
            moves += ones
            totalMoves[i] = moves
            if (boxes[i] == '1') {
                ones++
            }
        }

        ones = 0
        moves = 0
        for (i in boxes.indices) {
            moves + ones
            totalMoves[i] += moves
            if (boxes[i] == '1') {
                ones++
            }
        }
        return totalMoves
    }
}