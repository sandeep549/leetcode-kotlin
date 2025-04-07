# Understanding the Knapsack Problem in Detail

The Knapsack Problem is one of the most classic and fundamental problems in computer science and operations research. It’s widely used in optimization and decision-making scenarios.

---

## Table of Contents

1. Problem Definition
2. Types of Knapsack Problems
3. Real-World Applications
4. Solution Approaches
    - 1. Recursive Approach
    - 2. Memoization (Top-Down DP)
    - 3. Tabulation (Bottom-Up DP)
5. Kotlin Implementation
6. Time and Space Complexity
7. Conclusion

---

## 1. Problem Definition

Given a set of items, each with a weight and a value, determine the number of each item to include in a collection such that:

- The total weight is less than or equal to a given limit (the "capacity" of the knapsack).
- The total value is as large as possible.

### Inputs:
- `values`: List of integers representing the value of each item.
- `weights`: List of integers representing the weight of each item.
- `capacity`: Maximum weight the knapsack can carry.

### Output:
- Maximum total value achievable without exceeding the weight limit.

---

## 2. Types of Knapsack Problems

- **0/1 Knapsack Problem**: Each item can be included or excluded. Cannot be broken into smaller parts.
- **Fractional Knapsack Problem**: Items can be broken into smaller parts. Solvable using greedy approach.
- **Unbounded Knapsack**: Unlimited quantity of each item is available.

This document focuses on the **0/1 Knapsack Problem**.

---

## 3. Real-World Applications

- Resource allocation problems
- Budget management
- Cargo loading
- Portfolio selection

---

## 4. Solution Approaches

### 1. Recursive Approach (Naive)
This approach explores all combinations.

```kotlin
fun knapsackRecursive(weights: IntArray, values: IntArray, n: Int, capacity: Int): Int {
    if (n == 0 || capacity == 0) return 0

    return if (weights[n - 1] <= capacity) {
        maxOf(
            values[n - 1] + knapsackRecursive(weights, values, n - 1, capacity - weights[n - 1]),
            knapsackRecursive(weights, values, n - 1, capacity)
        )
    } else {
        knapsackRecursive(weights, values, n - 1, capacity)
    }
}
```

**Drawback**: Exponential time complexity \( O(2^n) \)

---

### 2. Memoization (Top-Down DP)
Optimized by storing intermediate results.

```kotlin
fun knapsackMemo(weights: IntArray, values: IntArray, n: Int, capacity: Int, memo: Array<IntArray>): Int {
    if (n == 0 || capacity == 0) return 0
    if (memo[n][capacity] != -1) return memo[n][capacity]

    memo[n][capacity] = if (weights[n - 1] <= capacity) {
        maxOf(
            values[n - 1] + knapsackMemo(weights, values, n - 1, capacity - weights[n - 1], memo),
            knapsackMemo(weights, values, n - 1, capacity, memo)
        )
    } else {
        knapsackMemo(weights, values, n - 1, capacity, memo)
    }
    return memo[n][capacity]
}
```

---

### 3. Tabulation (Bottom-Up DP)
Iterative and most optimized version.

```kotlin
fun knapsackTabulation(weights: IntArray, values: IntArray, capacity: Int): Int {
    val n = weights.size
    val dp = Array(n + 1) { IntArray(capacity + 1) }

    for (i in 1..n) {
        for (w in 0..capacity) {
            dp[i][w] = if (weights[i - 1] <= w) {
                maxOf(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w])
            } else {
                dp[i - 1][w]
            }
        }
    }
    return dp[n][capacity]
}
```

---

## 5. Kotlin Implementation Example

```kotlin
fun main() {
    val weights = intArrayOf(1, 3, 4, 5)
    val values = intArrayOf(1, 4, 5, 7)
    val capacity = 7
    val n = weights.size

    // Memoization
    val memo = Array(n + 1) { IntArray(capacity + 1) { -1 } }
    println("Maximum value (Memoization): ${knapsackMemo(weights, values, n, capacity, memo)}")

    // Tabulation
    println("Maximum value (Tabulation): ${knapsackTabulation(weights, values, capacity)}")
}
```

---

## 6. Time and Space Complexity

| Approach       | Time Complexity | Space Complexity |
|----------------|------------------|------------------|
| Recursive      | O(2^n)           | O(1)             |
| Memoization    | O(n * W)         | O(n * W)         |
| Tabulation     | O(n * W)         | O(n * W)         |

Where `n` is the number of items and `W` is the capacity of the knapsack.

---

## 7. Conclusion

The Knapsack Problem is a classic example of how brute-force methods can be improved using Dynamic Programming. The Tabulation method is preferred in most cases due to its clarity and iterative nature. Kotlin’s expressive syntax makes implementing these algorithms straightforward.

This problem not only helps in learning dynamic programming but also has direct applications in many optimization problems in real-world software systems.

---

Happy Learning! 🚀

