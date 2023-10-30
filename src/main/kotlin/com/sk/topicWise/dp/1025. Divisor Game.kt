package com.sk.topicWise.dp

class Solution1025 {
    fun divisorGame(n: Int): Boolean {
        return play(n, true)
    }

    private fun play(n: Int, aliceTurn: Boolean): Boolean {
        if (n == 1) return !aliceTurn // => if last is 1 and its alice turn she will always lose, means Alice should start with even to win.
        return play(n - 1, !aliceTurn)
    }

    fun divisorGame2(n: Int): Boolean {
        return n and 1 != 1
    }
}