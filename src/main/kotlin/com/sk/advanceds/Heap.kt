package com.sk.advanceds

import java.lang.IllegalStateException

class Heap(val arr: IntArray) {
    var heapSize: Int = arr.size

    init {
        heapifyMax(arr)
    }

    private fun heapifyMax(arr: IntArray) {
        for (i in heapSize / 2 - 1 downTo 0) {
            siftDown(arr, i, heapSize)
        }
    }

    private fun siftDown(arr: IntArray, i: Int, size: Int) {
        var largest = i
        val left = 2 * i + 1
        val right = 2 * i + 2
        if (left < size && arr[left] > arr[largest]) {
            largest = left
        }
        if (right < size && arr[right] > arr[largest]) {
            largest = right
        }
        if (largest != i) {
            arr[i] = arr[largest].also { arr[largest] = arr[i] } // swap
            siftDown(arr, largest, size)
        }
    }

    fun heappopMax(): Int {
        if (heapSize == 0) throw IllegalStateException("Heap is empty.")
        val max = arr[0]
        arr[0] = arr[heapSize - 1]
        heapSize--
        siftDown(arr, 0, heapSize)
        return max
    }

    fun top() = arr[0]
}