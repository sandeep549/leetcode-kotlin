# AGENTS.md — AI Agent Guide for leetcode-kotlin

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

