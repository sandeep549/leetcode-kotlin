package com.sk.leetcode.kotlin

import java.util.Arrays

private fun groupAnagrams2(strs: Array<String>): List<List<String>> {
    fun isanagram(s1: String, s2: String): Boolean {
        if (s1.length != s2.length) return false
        val map = mutableMapOf<Char, Int>()
        for (i in s1.indices) {
            var ch = s1[i]
            map.put(ch, map.getOrDefault(ch, 0) + 1)
            ch = s2[i]
            map.put(ch, map.getOrDefault(ch, 0) - 1)
        }
        for (value in map.values) {
            if (value != 0) return false
        }
        return true
    }

    val result = mutableListOf<MutableList<String>>()
    val arr = IntArray(strs.size)
    for (i in strs.indices) {
        val s1 = strs[i]
        val group = mutableListOf<String>()
        for (j in i..strs.lastIndex) {
            val s2 = strs[j]
            if (arr[j] == 1) continue
            if (i == j && arr[j] == 0) {
                group.add(s1)
                arr[j] = 1
                continue
            }
            if (isanagram(s1, s2)) {
                group.add(s2)
                arr[j] = 1
            }
        }
        if (group.isNotEmpty()) result.add(group)
    }
    return result
}

private fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val result = mutableMapOf<String, MutableList<String>>()
    if (strs.isEmpty()) return emptyList()
    for (s in strs) {
        val ca = s.toCharArray()
        Arrays.sort(ca)
        val key = String(ca)
        if (!result.containsKey(key)) result[key] = mutableListOf()
        result[key]!!.add(s)
    }
    return result.values.toList()
}

fun groupAnagrams3(strs: Array<String>): List<List<String?>?>? {
    val result = mutableMapOf<String, MutableList<String>>()
    if (strs.isEmpty()) return emptyList()
    val count = IntArray(26)
    for (s in strs) {
        count.fill(0)
        for (c in s.toCharArray()) count[c - 'a']++
        val sb = StringBuilder("")
        for (i in 0..25) {
            sb.append('#')
            sb.append(count[i])
        }
        val key = sb.toString()
        if (!result.containsKey(key)) result[key] = mutableListOf()
        result[key]!!.add(s)
    }
    return result.values.toList()
}