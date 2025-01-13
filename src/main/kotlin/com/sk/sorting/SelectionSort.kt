package com.sk.sorting;

class SelectionSort {
    fun selectionSort(arr: Array<Int>) {
        val n = arr.size

        for (i in 0 until n - 1) {
            // Find the minimum element in the unsorted part of the array
            var minIdx = i
            for (j in i + 1 until n) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j
                }
            }

            // Swap the found minimum element with the first element
            val temp = arr[minIdx]
            arr[minIdx] = arr[i]
            arr[i] = temp
        }
    }
}
