# Dijkstra's Algorithm in Kotlin

Dijkstra's algorithm is a popular algorithm for finding the shortest paths from a source node to all other nodes in a weighted graph, where all edge weights are non-negative. Below is a detailed explanation, pseudocode, and implementation in Kotlin.

---

## **Key Concepts**
1. **Graph Representation**:
    - The graph consists of vertices (nodes) and edges (connections between nodes with weights).
    - The weights on edges represent the cost, distance, or time to traverse between two nodes.

2. **Shortest Path**:
    - The goal is to find the minimum distance or cost to reach each node from the source node.

---

## **Algorithm Steps**

### **Input**:
- A graph `G(V, E)`, where `V` is the set of vertices, and `E` is the set of edges with weights.
- A source node `s`.

### **Output**:
- The shortest distance from `s` to all other nodes.

### **Procedure**

1. **Initialization**:
    - Assign a tentative distance of `0` to the source node and `\infty` (infinity) to all other nodes.
    - Create a priority queue (or a min-heap) to track nodes based on their tentative distances.
    - Keep a set of "visited nodes" to ensure nodes are not processed more than once.

2. **Process Nodes**:
    - Start with the source node.
    - For the current node:
        1. Check all its neighbors.
        2. Calculate the tentative distance to each neighbor:
           ```
           Tentative Distance = Current Node's Distance + Edge Weight
           ```
        3. If the calculated distance is smaller than the current known distance to the neighbor, update it.

3. **Mark as Visited**:
    - Mark the current node as "visited" (processed) and never revisit it.

4. **Repeat**:
    - Select the unvisited node with the smallest tentative distance (using the priority queue) as the next node.
    - Repeat until all nodes are visited or the target node is reached (if only the shortest path to one node is needed).

5. **Result**:
    - Once all nodes are processed, the shortest distances to all nodes from the source are finalized.

---

## **Pseudocode in Kotlin**

```kotlin
import java.util.PriorityQueue

fun dijkstra(graph: Map<String, List<Pair<String, Int>>>, source: String): Map<String, Int> {
   val distances = mutableMapOf<String, Int>().apply {
      graph.keys.forEach { this[it] = Int.MAX_VALUE }
      this[source] = 0
   }

   val visited = mutableSetOf<String>() // Explicit visited set
   val priorityQueue = PriorityQueue<Pair<String, Int>>(compareBy { it.second })
   priorityQueue.add(Pair(source, 0))

   while (priorityQueue.isNotEmpty()) {
      val (currentNode, currentDistance) = priorityQueue.poll()

      // Skip if the node is already visited
      if (currentNode in visited) continue
      visited.add(currentNode)

      for ((neighbor, weight) in graph[currentNode] ?: emptyList()) {
         val newDistance = currentDistance + weight

         if (newDistance < distances[neighbor]!!) {
            distances[neighbor] = newDistance
            priorityQueue.add(Pair(neighbor, newDistance))
         }
      }
   }

   return distances
}
```

---

## **Explanation**

1. **Graph Representation**:
    - The graph is represented as a `Map<String, List<Pair<String, Int>>>`.
        - Key: Node name (e.g., "A", "B").
        - Value: List of pairs representing neighbors and edge weights (e.g., `listOf(Pair("B", 1), Pair("C", 4))`).

2. **Initialization**:
    - Create a `distances` map where all nodes initially have a distance of `Int.MAX_VALUE`, except the source node, which is set to `0`.

3. **Priority Queue**:
    - Use a `PriorityQueue` to process nodes in order of their current tentative distances.

4. **Relaxation**:
    - For each neighbor of the current node, calculate a new tentative distance.
    - If the new distance is smaller than the previously known distance, update it in the `distances` map and add the neighbor to the queue.

5. **Output**:
    - The function returns a map of nodes and their shortest distances from the source.

---

## **Usage Example**

```kotlin
fun main() {
    val graph = mapOf(
        "A" to listOf(Pair("B", 1), Pair("C", 4)),
        "B" to listOf(Pair("A", 1), Pair("C", 2), Pair("D", 6)),
        "C" to listOf(Pair("A", 4), Pair("B", 2), Pair("D", 3)),
        "D" to listOf(Pair("B", 6), Pair("C", 3))
    )

    val source = "A"
    val shortestDistances = dijkstra(graph, source)

    println("Shortest distances from $source: $shortestDistances")
}
```

---

## **Output**
For the example graph:
```
Shortest distances from A: {A=0, B=1, C=3, D=6}
```

---

## **Applications**

1. **GPS Navigation systems**.
2. **Network routing protocols**.
3. **Shortest path problems in weighted graphs**.

