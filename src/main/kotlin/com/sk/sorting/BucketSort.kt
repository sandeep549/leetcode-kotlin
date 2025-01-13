package com.sk.sorting

class BucketSort {
    fun bucketSort(arr: IntArray, bucketCount: Int) {
        if (arr.isEmpty()) return

        // Find the maximum and minimum values to determine the range of the data
        val max = arr.maxOrNull() ?: return
        val min = arr.minOrNull() ?: return

        // Create buckets
        val buckets = Array(bucketCount) { mutableListOf<Int>() }

        // Distribute input array elements into buckets
        for (num in arr) {
            val bucketIndex = ((num - min) * (bucketCount - 1) / (max - min)).toInt()
            buckets[bucketIndex].add(num)
        }

        // Sort individual buckets and concatenate results
        var index = 0
        for (bucket in buckets) {
            bucket.sort()
            for (num in bucket) {
                arr[index++] = num
            }
        }
    }

    fun main() {
        val arr = intArrayOf(0, 5, 3, 9, 8, 2, 1, 4, 7, 6)
        bucketSort(arr, 5) // Specify the number of buckets
        println(arr.joinToString(", "))
    }

}