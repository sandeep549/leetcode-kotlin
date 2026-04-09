# AGENTS.md — AI Agent Guide for leetcode-kotlin

## AI Copilot Meta Instructions
> These rules apply every time a LeetCode problem is presented or a solution is requested.

1. **Always research the best-known solution first.**
   Before writing any code, reason about the theoretically optimal time and space complexity for the problem (consult known algorithms, LeetCode editorial patterns, and competitive programming knowledge). Do not default to the first working approach.

2. **Enumerate all viable approaches.**
   Present a comparison table of at least 2–3 approaches (e.g., brute-force → better → optimal) with their time and space complexities before implementing.

3. **Implement the optimal solution.**
   Always implement the most time-efficient solution (prefer lower space complexity as a tiebreaker). If a well-known named algorithm applies (e.g., Kadane's, Boyer-Moore, Dutch National Flag, Floyd's Cycle Detection), use and name it explicitly.

4. **Flag any existing solution quality issues.**
   If a prior solution exists in the repo and has a correctness bug, suboptimal complexity, or a better Kotlin-idiomatic equivalent, call it out with a clear ⚠️ warning before presenting the improved version.

5. **Prefer Kotlin-idiomatic code.**
   Use Kotlin standard library features (`groupingBy`, `eachCount`, `scan`, `runningFold`, etc.) when they produce equally efficient and more readable code. Follow the key patterns already established in this repo.

6. **Never add Copilot as a co-author in git commits.**
   Do not append any `Co-authored-by: GitHub Copilot` or similar trailer lines to commit messages.

---

## Project Overview
A personal Kotlin LeetCode solutions repository. No tests, no services — purely algorithmic solutions and reference material. Build target: Kotlin 1.9.10, JVM 11.

## Build Commands
```bash
./gradlew compileKotlin   # Compile all sources (primary verification step)
./gradlew build           # Full build
```
There are no test sources. Compilation success is the only automated check.

## Directory Structure & Navigation
```
src/main/kotlin/com/sk/
  set0/–set32/        # Solutions batched by addition order; ~10–12 problems per set
  topicWise/          # Solutions grouped by algorithm topic (preferred for new problems)
    binarysearch/     tree/    dp/    graph/    slidingwindow/
    twopointer/       unionfind/  monotonicStack/  heap/  trie/  ...
    SortingAlgorithms/  # Canonical sorting implementations by algorithm family
    easy/ medium/ hard/   # sub-groupings inside some topic folders
  advanceds/          # Standalone custom data structure impls (Trie, DisjointSet, Heap)
  customimplementation/ # Queue abstractions and concrete impls (e.g., MonotonicQueue, MonotonicDecreasingQueue)
  datamodels/         # Shared model classes (NTreeNode)
  sorting/            # Classic sorting algorithm implementations
  z_ImportantCodeSnippet/  # Reusable reference snippets (iterative traversals, etc.)
  todo-revise/        # Problems flagged for revisiting
  leetcode/           # Notes plus legacy solution buckets (`kotlin/`, `google/`)
  *.md                # Algorithm explainers (Kadane, Dijkstra, Floyd Warshall, 0-1 BFS)
  0000_TrickyCode.kt  # Scratchpad for math tricks (e.g., ceiling division: (p+m-1)/m)
  Test1.kt            # Scratch file for active work-in-progress
```

## Naming Conventions
- **File name**: `{problemNumber}. {Problem Title}.kt` — e.g., `110. Balanced Binary Tree.kt`
- **Class name**: `Solution{problemNumber}` — e.g., `class Solution110`
- **Package**: mirrors directory path — e.g., `package com.sk.topicWise.binarysearch`
- New solutions go in `topicWise/{topic}/` (preferred) or a new `set{N}/` folder.
- Legacy files under `leetcode/kotlin/`, `leetcode/google/`, or top-level `topicWise/` may not follow the naming rule; keep existing style when editing in place.

## Shared Data Models
Always import these instead of redefining:
```kotlin
import com.sk.topicWise.tree.TreeNode   // Binary tree node (val, left, right, optional parent)
import com.sk.datamodels.NTreeNode      // N-ary tree node (val, children: ArrayList<NTreeNode>?)
```

## Key Patterns
- **`ArrayDeque` over `Stack`**: `Stack` is deprecated; use `ArrayDeque<T>` as a stack (`addLast`/`removeLast`) or queue (`addLast`/`removeFirst`).
- **`//todo:` comments**: Used inline to flag iterative improvement (e.g., `//todo: iterative`). Do not remove.
- **Multiple approaches in one file**: Some files contain 2–3 solution variants (e.g., `pivotArray` + `pivotArray2`). This is intentional — keep all variants.
- **`!!` operator**: Used deliberately where null is logically impossible; the codebase accepts this Kotlin verbosity consciously (see `leetcode/AnnoyingThingsForMeInKotlin`).

## Reference Files Worth Reading Before Solving
| Topic | Reference |
|-------|-----------|
| Binary tree iterative traversal | `z_ImportantCodeSnippet/Binary Tree Iterative Traversal.kt` |
| Union-Find / Disjoint Set | `advanceds/DisjointSetDataStructure1.kt` |
| Trie | `advanceds/Trie1.kt`, `advanceds/Trie2.kt` |
| Monotonic queue interface | `customimplementation/MonotonicQueue.kt` |
| 0-1 BFS, Dijkstra, Floyd Warshall, Kadane | `*.md` files at `com/sk/` root |
| Named algorithms (Boyer-Moore, Dutch National Flag) | `topicWise/NamedAlgorithms/` |

