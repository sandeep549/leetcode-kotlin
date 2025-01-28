# Floyd-Warshall Algorithm

The **Floyd-Warshall algorithm** is a dynamic programming algorithm used to find the shortest paths between all pairs of vertices in a weighted graph. It works for both directed and undirected graphs and can handle graphs with negative weights, as long as there are no negative weight cycles.

---

## Key Concepts:
- It computes the shortest paths in **O(V³)** time, where \( V \) is the number of vertices in the graph.
- The algorithm progressively considers intermediate vertices for paths between pairs of vertices.
- It uses a 2D matrix to store distances, where `dist[i][j]` represents the shortest distance from vertex \( i \) to \( j \).

---

## Steps of the Algorithm:
1. **Initialization**:
    - Create a distance matrix `dist[][]` where:
        - \( \text{dist}[i][j] = w(i, j) \) (weight of the edge from \( i \) to \( j \)).
        - \( \text{dist}[i][j] = \infty \) if there is no edge between \( i \) and \( j \), except \( \text{dist}[i][i] = 0 \).

2. **Relaxation**:
    - For each vertex \( k \), treat it as an intermediate vertex, and update all pairs of vertices \( (i, j) \) to check if going through \( k \) offers a shorter path.

   Formula:
   \[
   \text{dist}[i][j] = \min(\text{dist}[i][j], \text{dist}[i][k] + \text{dist}[k][j])
   \]

3. **Result**:
    - After \( V \) iterations, `dist[i][j]` contains the shortest distance from vertex \( i \) to \( j \).

---

## Kotlin Implementation:
```kotlin
fun floydWarshall(graph: Array<IntArray>): Array<IntArray> {
    val n = graph.size
    val dist = Array(n) { graph[it].clone() }

    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (dist[i][k] != Int.MAX_VALUE && dist[k][j] != Int.MAX_VALUE) {
                    dist[i][j] = minOf(dist[i][j], dist[i][k] + dist[k][j])
                }
            }
        }
    }
    return dist
}

// Helper function to print the distance matrix
fun printMatrix(matrix: Array<IntArray>) {
    for (row in matrix) {
        for (value in row) {
            print(if (value == Int.MAX_VALUE) "INF " else "$value ")
        }
        println()
    }
}

// Example usage
fun main() {
    val INF = Int.MAX_VALUE
    val graph = arrayOf(
        intArrayOf(0, 3, INF, 5),
        intArrayOf(2, 0, INF, 4),
        intArrayOf(INF, 1, 0, INF),
        intArrayOf(INF, INF, 2, 0)
    )

    val result = floydWarshall(graph)
    println("Shortest distances between all pairs of vertices:")
    printMatrix(result)
}
