package com.sk.topicWise.randomnumber

import java.util.Random

private class Solution(nums: IntArray) {

    val copy: IntArray
    val original: IntArray
    val random: Random

    init {
        this.original = nums
        this.copy = nums.copyOf()
        random = Random()
    }

    /** Resets the array to its original configuration and return it. */
    fun reset(): IntArray {
        return original
    }

    /** Returns a random shuffling of the array. */
    fun shuffle(): IntArray {
        val list = original.copyOf().asList().toMutableList()
        var c = 0
        while (c < original.size) {
            val index = c + random.nextInt(original.size - c)
            copy[c] = copy[index].also { copy[index] = copy[c] }
            c++
        }
        return copy
    }
}
