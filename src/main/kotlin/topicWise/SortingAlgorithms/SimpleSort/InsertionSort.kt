package topicWise.SortingAlgorithms.SimpleSort
// https://en.wikipedia.org/wiki/Sorting_algorithm
/*
Algorithm
To sort an array of size n in ascending order:
1: Iterate from arr[1] to arr[n] over the array.
2: Compare the current element (key) to its predecessor.
3: If the key element is smaller than its predecessor, compare it to the elements before. Move the greater elements one position up to make space for the swapped element.

-------------------------
| Time       |  O(n^2)  |
| Aux-Space  |  O(1)    |
-------------------------
| In-place   |  yes     |
| Stable     |  yes     |
| Online     |  yes     |
-------------------------
Highlights:
Time Complexity: O(n*2)
Auxiliary Space: O(1)
Boundary Cases: Insertion sort takes maximum time to sort if elements are sorted in reverse order. And it takes minimum time (Order of n) when elements are already sorted.
Algorithmic Paradigm: Incremental Approach

1. Time complexity is O(n*k), when each element in input is no more than k places away from its sorted position
2. If array is already sorted, then inner loop won't execute and time is O(n)
3. Good when input is almost sorted
4. Good for small input size
5. Takes max time O(n^2) when input is in reverse order
 */

private fun insertionSort(arr: IntArray) {
    for (i in 1..arr.lastIndex) {
        val key = arr[i]
        var j = i - 1
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j]
            j--
        }
        arr[j + 1] = key
    }
}

fun main() {
    val arr = intArrayOf(64, 25, 12, 22, 11)
    println(insertionSort(arr))
}
