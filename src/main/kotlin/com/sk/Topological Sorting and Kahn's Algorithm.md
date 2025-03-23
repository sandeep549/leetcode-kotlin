# **Topological Sorting and Kahn's Algorithm**

## **What is Topological Sort in a Graph?**
Topological sorting is an ordering of the vertices in a **Directed Acyclic Graph (DAG)** such that for every directed edge **(u → v)**, vertex **u** comes before vertex **v** in the ordering.

### **Key Points:**
1. Only applicable to **DAGs** (Directed Acyclic Graphs).
2. Provides a linear order of vertices, which is useful for tasks like scheduling and dependency resolution.
3. A graph can have **multiple valid topological orderings**.

### **Example:**
Consider the following graph:

```
    5 → 0
    5 → 2
    4 → 0
    4 → 1
    2 → 3
    3 → 1
```

One possible **topological ordering**: **5, 4, 2, 3, 1, 0**.

---

## **Kahn’s Algorithm for Topological Sorting**
Kahn's Algorithm is a **BFS-based** approach to find a topological sort of a DAG.

### **Steps:**
1. **Compute the in-degree** (number of incoming edges) for each vertex.
2. **Initialize a queue** with all vertices having in-degree **0**.
3. **Process the queue**:
    - Remove a vertex **u** from the queue and add it to the result.
    - Reduce the in-degree of all its adjacent vertices (**v**).
    - If an adjacent vertex **v** now has in-degree **0**, add it to the queue.
4. Repeat until the queue is empty.
5. If all vertices are processed, we get a valid topological order. If not, there is a cycle in the graph.

---

## **Kotlin Implementation of Kahn’s Algorithm**
```kotlin
import java.util.*

fun topologicalSortKahn(graph: Map<Int, List<Int>>, numNodes: Int): List<Int> {
    val inDegree = IntArray(numNodes) { 0 }
    val result = mutableListOf<Int>()
    
    // Compute in-degrees
    for (edges in graph.values) {
        for (v in edges) {
            inDegree[v]++
        }
    }

    // Add all vertices with in-degree 0 to queue
    val queue: Queue<Int> = LinkedList()
    for (i in 0 until numNodes) {
        if (inDegree[i] == 0) {
            queue.add(i)
        }
    }

    while (queue.isNotEmpty()) {
        val u = queue.poll()
        result.add(u)

        // Reduce in-degree of adjacent vertices
        graph[u]?.forEach { v ->
            inDegree[v]--
            if (inDegree[v] == 0) {
                queue.add(v)
            }
        }
    }

    // If all nodes are processed, return result, else graph has a cycle
    return if (result.size == numNodes) result else emptyList()
}

// Example Usage
fun main() {
    val graph = mapOf(
        5 to listOf(0, 2),
        4 to listOf(0, 1),
        2 to listOf(3),
        3 to listOf(1)
    )
    val numNodes = 6
    println(topologicalSortKahn(graph, numNodes)) // Output: [5, 4, 2, 3, 1, 0]
}
```

---

## **Time Complexity:**
- **O(V + E)**, where **V** is the number of vertices and **E** is the number of edges.
- The in-degree calculation takes **O(V + E)**.
- Processing the queue and edges takes **O(V + E)**.

---

## **When to Use Topological Sort?**
- **Task scheduling** (e.g., resolving dependencies in a build system).
- **Course prerequisite ordering**.
- **Dependency resolution** (e.g., package managers like npm, pip).
- **Compilation order of files in a programming language**.

