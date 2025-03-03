# Kadane's Algorithm: Maximum Subarray Sum Explained

Kadane's Algorithm is an efficient way to find the maximum sum of a contiguous subarray within a given one-dimensional numeric array. It is widely used in competitive programming and real-world applications where optimization problems arise.

## Problem Statement
Given an array of integers (both positive and negative), find the contiguous subarray that has the largest sum.

### Example
**Input:**  
`arr = [-2, 1, -3, 4, -1, 2, 1, -5, 4]`

**Output:**  
`Maximum subarray sum = 6`  
(The subarray `[4, -1, 2, 1]` has the largest sum.)

## Naive Approach
A brute-force solution would be to generate all possible subarrays and compute their sums, which results in a time complexity of **O(n²)**. However, this is inefficient for large inputs.

## Kadane's Algorithm: Efficient Approach
Kadane’s Algorithm optimally finds the maximum sum in **O(n)** time using dynamic programming. It maintains two values:
1. `current_sum` – Maximum sum ending at the current index.
2. `max_sum` – Maximum sum found so far.

### Algorithm Steps
1. Initialize `max_sum = arr[0]` and `current_sum = arr[0]`.
2. Iterate through the array starting from index 1.
3. For each element `arr[i]`, update `current_sum` as:
   ```kotlin
   current_sum = max(arr[i], current_sum + arr[i])
   ```
4. Update `max_sum` whenever `current_sum` exceeds `max_sum`.
5. Return `max_sum` at the end.

### Implementation in Kotlin
```kotlin
fun maxSubArray(arr: IntArray): Int {
    var maxSum = arr[0]
    var currentSum = arr[0]
    
    for (i in 1 until arr.size) {
        currentSum = maxOf(arr[i], currentSum + arr[i])
        maxSum = maxOf(maxSum, currentSum)
    }
    return maxSum
}

fun main() {
    val arr = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    println("Maximum subarray sum: ${maxSubArray(arr)}")
}
```

## Explanation with Dry Run
Consider `arr = [-2, 1, -3, 4, -1, 2, 1, -5, 4]`:

| Index | Element | Current Sum | Max Sum |
|--------|---------|--------------|---------|
| 0      | -2      | -2           | -2      |
| 1      | 1       | 1            | 1       |
| 2      | -3      | -2           | 1       |
| 3      | 4       | 4            | 4       |
| 4      | -1      | 3            | 4       |
| 5      | 2       | 5            | 5       |
| 6      | 1       | 6            | 6       |
| 7      | -5      | 1            | 6       |
| 8      | 4       | 5            | 6       |

Thus, the maximum subarray sum is **6**.

## Complexity Analysis
- **Time Complexity:** O(n) – Each element is processed once.
- **Space Complexity:** O(1) – Only a few extra variables are used.

## Applications
- Financial analysis (maximum profit over a period)
- Image processing (finding brightest contiguous regions)
- DNA sequencing (finding high-value sequences)
- Machine learning (feature optimization)

## Variants & Extensions
1. **Finding the subarray itself** – Track start and end indices.
2. **Handling circular arrays** – Modify Kadane’s algorithm to consider wrapping cases.
3. **2D Kadane’s Algorithm** – Used in problems involving matrices.

## Conclusion
Kadane’s Algorithm is a powerful and efficient technique for solving the maximum subarray sum problem. By reducing the complexity to O(n), it makes handling large datasets feasible. Mastering this algorithm is essential for tackling a variety of optimization problems in coding interviews and real-world applications.

