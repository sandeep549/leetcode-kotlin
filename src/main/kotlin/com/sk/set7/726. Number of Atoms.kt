package com.sk.set7

import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.MutableMap
import kotlin.collections.mutableMapOf
import kotlin.collections.set
import kotlin.collections.sorted


class Solution726 {
    fun countOfAtoms(formula: String): String {
        val stack = ArrayDeque<MutableMap<String, Int>>()
        var map = mutableMapOf<String, Int>()
        var index = 0
        val size = formula.length
        while (index < size) {
            val char = formula[index]
            //index++
            if (char == '(') {
                stack.addLast(map)
                map = mutableMapOf()
                index++
            } else if (char == ')') {
                var i = 1
                while (index + i < size && formula[index+i].isDigit()) i++
                var countString = formula.substring(index+1, i)
                val count = if (countString.isEmpty()) 1 else countString.toInt()

                if (!stack.isEmpty()) {
                    val temp = map
                    map = stack.removeLast()
                    for (key in temp.keys) {
                        map[key] = map.getOrDefault(key, 0) + temp[key]!! * count
                    }
                }
                index += i
            } else {
                var i = 1
                while (index + i < size && formula[index+i].isLowerCase()) {
                    i++
                }
                val s = formula.substring(index, i)
                index += i

                i = 0
                while (index + i < size && formula[index+i].isDigit()) i++
                var countString = formula.substring(index, i)
                val count = if (countString.isEmpty()) 1 else countString.toInt()
                map[s] = map.getOrDefault(s, 0) + count
                index += i
            }
        }
        val sb = StringBuilder()
        for (key in map.keys.sorted()) {
            sb.append(key)
            if (map[key]!! > 1) sb.append(map[key])
        }
        return sb.toString()
    }
}


internal class Solution {
    fun countOfAtoms(formula: String): String {
        val stack = Stack<MutableMap<String, Int>>()
        var map: MutableMap<String, Int> = HashMap()
        var i = 0
        val n = formula.length
        while (i < n) {
            val c = formula[i]
            i++
            if (c == '(') {
                stack.push(map)
                map = HashMap()
            } else if (c == ')') {
                var `val` = 0
                while (i < n && Character.isDigit(formula[i])) `val` = `val` * 10 + formula[i++].code - '0'.code

                if (`val` == 0) `val` = 1
                if (!stack.isEmpty()) {
                    val temp: Map<String, Int> = map
                    map = stack.pop()
                    for (key in temp.keys) map[key] = map.getOrDefault(key, 0) + temp[key]!! * `val`
                }
            } else {
                val start = i - 1
                while (i < n && Character.isLowerCase(formula[i])) {
                    i++
                }
                val s = formula.substring(start, i)
                var `val` = 0
                while (i < n && Character.isDigit(formula[i])) `val` = `val` * 10 + formula[i++].code - '0'.code
                if (`val` == 0) `val` = 1
                map[s] = map.getOrDefault(s, 0) + `val`
            }
        }
        val sb = java.lang.StringBuilder()
        val list: List<String> = ArrayList(map.keys)
        Collections.sort(list)
        for (key in list) {
            sb.append(key)
            if (map[key]!! > 1) sb.append(map[key])
        }
        return sb.toString()
    }
}