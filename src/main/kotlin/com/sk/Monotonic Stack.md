# **Monotonic Stack: Usage, Identification, and Key Details**

## **1. What is a Monotonic Stack?**
A **monotonic stack** is a stack that maintains its elements in either **increasing** or **decreasing** order. It is commonly used in problems that require efficiently finding the **next/previous greater or smaller element**.

### **Types of Monotonic Stacks:**
1. **Monotonically Increasing Stack**: Each element is **greater than or equal** to the one below it.
2. **Monotonically Decreasing Stack**: Each element is **less than or equal** to the one below it.

---

## **2. Why Use a Monotonic Stack?**
A **monotonic stack** is useful when solving problems that require finding elements in relation to their neighbors efficiently. Instead of using a brute-force **O(n²) approach**, a **monotonic stack reduces complexity to O(n)** by ensuring each element is pushed and popped at most once.

### **Key Advantages:**
✅ **Efficient O(n) Time Complexity**  
✅ **Solves Next/Previous Greater/Smaller Element Problems**  
✅ **Reduces Nested Loops and Improves Performance**  
✅ **Useful for Interval, Range, and Sliding Window Problems**

---

## **3. How to Identify When Monotonic Stack Can Be Used?**
You can use a monotonic stack if the problem:
- Requires finding the **next or previous greater/smaller element**.
- Mentions **ranges**, **windows**, or **subarrays** where comparisons are needed.
- Has **constraints that suggest O(n²) is too slow** and needs optimization.
- Involves **greedy element selection**, where we process elements in order and discard unnecessary ones.
- Includes **histogram-like structures**, such as rectangles or stock spans.

### **Common Problem Statements Indicating Monotonic Stack Usage:**
1. **Next Greater Element** (Find the next greater value for each element in an array)
2. **Next Smaller Element** (Find the next smaller value for each element in an array)
3. **Previous Greater Element** (Find the last greater value before each element)
4. **Previous Smaller Element** (Find the last smaller value before each element)
5. **Largest Rectangle in Histogram** (Finding maximum rectangle area in a histogram)
6. **Trapping Rain Water** (Finding boundaries to calculate trapped water)
7. **Stock Span Problem** (Finding the number of days a stock was lower than today)

---

## **4. Key Use Cases and Examples**

### **(A) Next Greater Element**
Find the **next greater element** for each index in an array.

```kotlin
fun nextGreaterElements(nums: IntArray): IntArray {
    val stack = ArrayDeque<Int>()  // Stores indices
    val res = IntArray(nums.size) { -1 }

    for (i in nums.indices) {
        while (stack.isNotEmpty() && nums[stack.last()] < nums[i]) {
            res[stack.removeLast()] = nums[i]
        }
        stack.addLast(i)
    }
    return res
}
```

**Key Observations:**
- **Stack maintains decreasing order** (small elements are removed when a larger one is found).
- **O(n) Complexity**: Each element is pushed and popped at most once.

---

### **(B) Next Smaller Element**
Find the **next smaller element** for each index in an array.

```kotlin
fun nextSmallerElements(nums: IntArray): IntArray {
    val stack = ArrayDeque<Int>()
    val res = IntArray(nums.size) { -1 }

    for (i in nums.indices) {
        while (stack.isNotEmpty() && nums[stack.last()] > nums[i]) {
            res[stack.removeLast()] = nums[i]
        }
        stack.addLast(i)
    }
    return res
}
```

💡 **Change from Next Greater:**
- Maintain an **increasing stack** (pop when a smaller element is found).

---

### **(C) Largest Rectangle in Histogram**
Find the **largest rectangular area** in a histogram.

```kotlin
fun largestRectangleArea(heights: IntArray): Int {
    val stack = ArrayDeque<Int>()
    var maxArea = 0
    val n = heights.size

    for (i in 0..n) {
        val h = if (i == n) 0 else heights[i]
        while (stack.isNotEmpty() && heights[stack.last()] > h) {
            val height = heights[stack.removeLast()]
            val width = if (stack.isEmpty()) i else i - stack.last() - 1
            maxArea = maxOf(maxArea, height * width)
        }
        stack.addLast(i)
    }
    return maxArea
}
```

💡 **Why It Works:**
- **Pop when a smaller element appears** to determine width.
- **O(n) efficiency** by ensuring each element is pushed and popped once.

---

## **5. Key Takeaways**

| Concept            | Increasing Stack                 | Decreasing Stack                |
|--------------------|--------------------------------|--------------------------------|
| Used for          | Next Smaller Element           | Next Greater Element           |
| Stack Order       | Elements in increasing order   | Elements in decreasing order   |
| When to pop       | If a smaller element appears   | If a greater element appears   |
| Complexity        | **O(n)** (Each element is pushed & popped once) |

---

## **6. Summary: When to Consider Monotonic Stack?**

✅ **Check if the problem involves:**
- **Next/Previous Greater/Smaller elements**
- **Range-based comparisons**
- **Stack-like processing of elements**
- **Sliding window optimization**
- **Histogram or rainwater problems**

✅ **If brute force is O(n²) and needs optimization, a monotonic stack can reduce it to O(n).**

Would you like to explore more problems with Monotonic Stack? 🚀

