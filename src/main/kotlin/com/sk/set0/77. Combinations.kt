package com.sk.set0


class Solution77 {
    fun combine(n: Int, k: Int): List<List<Int>> {
        val result = ArrayList<ArrayList<Int>>()
        combine(1, n, k, ArrayList(), result)
        return result
    }

    private fun combine(start: Int, end: Int, k: Int, list: ArrayList<Int>, result: ArrayList<ArrayList<Int>>) {
        if (k == 0) {
            result.add(list)
            return
        }
        for (i in start..end) {
            val list = ArrayList(list) // make fresh copy of list
            list.add(i)
            combine(i + 1, end, k - 1, list, result)
        }
    }

    fun combine2(n: Int, k: Int): List<List<Int>> {
        val result: MutableList<List<Int>> = ArrayList()
        var i = 0
        val arr = IntArray(k)
        while (i >= 0) {
            arr[i]++
            if (arr[i] > n) {
                i--
            } else if (i == k - 1) {
                val combination = ArrayList<Int>()
                for (num in arr) {
                    combination.add(num)
                }
                result.add(combination)
            } else {
                i++
                arr[i] = arr[i - 1]
            }
        }
        return result
    }

    // https://leetcode.com/problems/combinations/solutions/26992/short-iterative-c-answer-8ms/?envType=study-plan-v2&envId=top-interview-150
    fun combine3(n: Int, k: Int): List<List<Int>> {
        val result: MutableList<List<Int>> = ArrayList()
        var i = 0
        val arr = IntArray(k)
        val list = ArrayList<Int>()
        while (i >= 0) {
            arr[i]++
            list.add(arr[i])

            if (arr[i] > n) {
                i--
                list.removeLast()
                if (list.isNotEmpty()) list.removeLast()
            } else if (i == k - 1) {
                result.add(ArrayList(list))
                list.removeLast()
            } else {
                i++
                arr[i] = arr[i - 1]
            }
        }
        return result
    }
}