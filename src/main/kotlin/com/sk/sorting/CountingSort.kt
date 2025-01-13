package com.sk.sorting

class CountingSort {
    fun countingSort(arr: IntArray): IntArray {
        if (arr.isEmpty()) return arr

        // Find the maximum value in the array
        val max = arr.maxOrNull() ?: return arr
        // Create a count array to store the count of each unique element
        val count = IntArray(max + 1)

        // Store the count of each element
        for (num in arr) {
            count[num]++
        }

        // Modify the count array such that each element at each index
        // stores the sum of previous counts. This gives us the positions
        // of elements in the sorted array.
        for (i in 1 until count.size) {
            count[i] += count[i - 1]
        }

        // Output array to store the sorted order
        val output = IntArray(arr.size)
        // Build the output array
        for (i in arr.indices.reversed()) {
            output[count[arr[i]] - 1] = arr[i]
            count[arr[i]]--
        }

        return output
    }

    fun main() {
        val arr = intArrayOf(4, 2, 2, 8, 3, 3, 1)
        val sortedArr = countingSort(arr)
        println(sortedArr.joinToString(", "))
    }

}