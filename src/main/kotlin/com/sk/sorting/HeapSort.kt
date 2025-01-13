package com.sk.sorting

class HeapSort {
    fun heapSort(arr: IntArray) {
        val n = arr.size

        // Build a max heap
        for (i in n / 2 - 1 downTo 0) {
            heapify(arr, n, i)
        }

        // Extract elements one by one from the heap
        for (i in n - 1 downTo 1) {
            // Move current root to end
            val temp = arr[0]
            arr[0] = arr[i]
            arr[i] = temp

            // Call max heapify on the reduced heap
            heapify(arr, i, 0)
        }
    }

    fun heapify(arr: IntArray, n: Int, i: Int) {
        var largest = i // Initialize largest as root
        val left = 2 * i + 1 // left = 2*i + 1
        val right = 2 * i + 2 // right = 2*i + 2

        // Check if left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left
        }

        // Check if right child is larger than the largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right
        }

        // Swap and continue heapifying if root is not largest
        if (largest != i) {
            val swap = arr[i]
            arr[i] = arr[largest]
            arr[largest] = swap

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest)
        }
    }

    fun main() {
        val arr = intArrayOf(12, 11, 13, 5, 6, 7)
        heapSort(arr)
        println(arr.joinToString(", "))
    }

}