package com.sk.sorting

class RadixSort {
    fun countingSortForRadix(arr: IntArray, exp: Int) {
        val n = arr.size
        val output = IntArray(n) // output array
        val count = IntArray(10) // count array to store the count of digits (0 to 9)

        // Store count of occurrences in count[]
        for (i in arr.indices) {
            val index = (arr[i] / exp) % 10
            count[index]++
        }

        // Change count[i] so that count[i] contains the actual position of this digit in output[]
        for (i in 1 until 10) {
            count[i] += count[i - 1]
        }

        // Build the output array
        for (i in arr.indices.reversed()) {
            val index = (arr[i] / exp) % 10
            output[count[index] - 1] = arr[i]
            count[index]--
        }

        // Copy the output array to arr[], so that arr[] now contains sorted numbers according to the current digit
        for (i in arr.indices) {
            arr[i] = output[i]
        }
    }

    fun radixSort(arr: IntArray) {
        // Find the maximum number to know the number of digits
        val max = arr.maxOrNull() ?: return

        // Do counting sort for every digit. Note that instead of passing the digit number,
        // exp is passed. exp is 10^i where i is the current digit number
        var exp = 1
        while (max / exp > 0) {
            countingSortForRadix(arr, exp)
            exp *= 10
        }
    }

    fun main() {
        val arr = intArrayOf(170, 45, 75, 90, 802, 24, 2, 66)
        radixSort(arr)
        println(arr.joinToString(", "))
    }

}