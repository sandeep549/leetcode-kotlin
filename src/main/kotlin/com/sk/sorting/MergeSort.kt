package com.sk.sorting

class MergeSort {
    fun mergeSort(arr: Array<Int>) {
        if (arr.size < 2) return

        val mid = arr.size / 2
        val left = arr.copyOfRange(0, mid)
        val right = arr.copyOfRange(mid, arr.size)

        mergeSort(left)
        mergeSort(right)
        merge(arr, left, right)
    }

    private fun merge(arr: Array<Int>, left: Array<Int>, right: Array<Int>) {
        var i = 0
        var j = 0
        var k = 0

        while (i < left.size && j < right.size) {
            if (left[i] <= right[j]) {
                arr[k] = left[i]
                i++
            } else {
                arr[k] = right[j]
                j++
            }
            k++
        }

        while (i < left.size) {
            arr[k] = left[i]
            i++
            k++
        }

        while (j < right.size) {
            arr[k] = right[j]
            j++
            k++
        }
    }

    fun main() {
        val arr = arrayOf(12, 11, 13, 5, 6, 7)
        println("Original array: ${arr.joinToString()}")
        mergeSort(arr)
        println("Sorted array: ${arr.joinToString()}")
    }

}