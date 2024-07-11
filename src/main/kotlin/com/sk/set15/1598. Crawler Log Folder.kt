package com.sk.set15

class Solution {
    fun minOperations(logs: Array<String>): Int {
        var folderDepth = 0
        logs.forEach { operation ->
            when(operation) {
                "./" -> {
                    // do nothing
                }
                "../" -> {
                    if (folderDepth > 0) folderDepth--
                }
                else -> {
                    folderDepth++
                }
            }
        }
        return folderDepth
    }
}