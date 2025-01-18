# 0-1 Breadth-First Search (0-1 BFS)

## Overview

0-1 Breadth-First Search (0-1 BFS) is an optimized algorithm for finding the shortest path in a graph where edge weights are restricted to either 0 or 1. It improves upon Dijkstra's algorithm for such cases by using a deque (double-ended queue) instead of a priority queue, making it both simpler and faster for the problem at hand.

---

## Key Steps in 0-1 BFS

1. **Initialization**:
   - Create a deque to process the nodes.
   - Maintain a distance array (or map) to store the shortest distance from the source to each node. Initialize all distances to infinity (`inf`), except for the source node, which is set to 0.

2. **Processing Nodes**:
   - Start with the source node in the deque.
   - For each node, examine its neighbors. If moving to a neighbor improves the shortest distance:
      - If the edge weight is 0, add the neighbor to the **front** of the deque.
      - If the edge weight is 1, add the neighbor to the **back** of the deque.

3. **Distance Update**:
   - Update the shortest distance for the neighbor node if a shorter path is found.

4. **Termination**:
   - Continue processing nodes from the deque until it is empty.

---

## Time Complexity

- **O(V + E)**: Since each edge is processed exactly once, the algorithm runs in linear time relative to the number of vertices \( V \) and edges \( E \).

---

## Pseudocode in Kotlin

```kotlin
import java.util.ArrayDeque

fun zeroOneBFS(graph: List<List<Pair<Int, Int>>>, source: Int): IntArray {
    val n = graph.size
    val dist = IntArray(n) { Int.MAX_VALUE }
    dist[source] = 0

    val deque = ArrayDeque<Int>()
    deque.add(source)

    while (deque.isNotEmpty()) {
        val node = deque.removeFirst()

        for ((neighbor, weight) in graph[node]) {
            if (dist[node] + weight < dist[neighbor]) {
                dist[neighbor] = dist[node] + weight
                if (weight == 0) {
                    deque.addFirst(neighbor)
                } else {
                    deque.addLast(neighbor)
                }
            }
        }
    }

    return dist
}
```

---

## Example

### Input

Graph represented as an adjacency list:

```kotlin
val graph = listOf(
    listOf(Pair(1, 0), Pair(2, 1)),  // Edges from node 0
    listOf(Pair(2, 1), Pair(3, 0)),  // Edges from node 1
    listOf(Pair(3, 1)),              // Edges from node 2
    emptyList()                      // Node 3 has no outgoing edges
)
val source = 0
```

### Usage

```kotlin
val shortestDistances = zeroOneBFS(graph, source)
println(shortestDistances.joinToString(", "))  // Output: Shortest distances from the source
```

### Output

For the given graph, the output will be:

```
0, 0, 1, 0
```

---

## Why Use 0-1 BFS?

- Simplifies the process for graphs with weights restricted to 0 or 1.
- Uses a deque to efficiently prioritize nodes connected by 0-weight edges.
- Avoids the overhead of maintaining a priority queue, leading to better performance for this specific use case.

---

Let me know if you need further examples or clarifications!

