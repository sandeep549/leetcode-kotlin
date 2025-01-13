package com.sk.sorting

class QuickSort {
    fun quickSort(arr: Array<Int>, low: Int, high: Int) {
        if (low < high) {
            // Partition the array
            val pi = partition(arr, low, high)

            // Recursively sort the sub-arrays
            quickSort(arr, low, pi - 1)
            quickSort(arr, pi + 1, high)
        }
    }

    private fun partition(arr: Array<Int>, low: Int, high: Int): Int {
        val pivot = arr[high]
        var i = low - 1

        for (j in low until high) {
            if (arr[j] <= pivot) {
                i++
                // Swap arr[i] and arr[j]
                val temp = arr[i]
                arr[i] = arr[j]
                arr[j] = temp
            }
        }

        // Swap arr[i + 1] and arr[high] (or pivot)
        val temp = arr[i + 1]
        arr[i + 1] = arr[high]
        arr[high] = temp

        return i + 1
    }

}