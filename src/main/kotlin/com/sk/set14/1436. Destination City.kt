package com.sk.set14


class Solution1436 {
    fun destCity(paths: List<List<String>>): String {
        val set = HashSet<String>()
        for (path in paths) set.add(path[1])
        for (path in paths) set.remove(path[0])
        return set.iterator().next()
    }
}