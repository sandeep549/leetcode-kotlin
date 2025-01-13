package com.sk.set13

class Solution {
    fun findTheCity(n: Int, edges: Array<IntArray>, distanceThreshold: Int): Int {
        val distanceArr = Array(n) { IntArray(n) { -1 } }
        val adjList = mutableMapOf<Int, MutableList<Int>>()
        edges.forEach { (from, to, distance) ->
            distanceArr[from][to] = distance
            distanceArr[to][from] = distance
            adjList[from] = adjList.getOrDefault(from, mutableListOf()).also { it.add(to) }
            adjList[to] = adjList.getOrDefault(to, mutableListOf()).also { it.add(from) }
        }


    }
}