package com.sk.medium


class Solution49 {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val res = ArrayList<ArrayList<String>>()
        for (str in strs) {
            var found = false
            for (list in res) {
                if (list.isNotEmpty() && isAnagram(str, list[0])) {
                    list.add(str)
                    found = true
                    break
                }
            }
            if (found.not()) {
                val l = ArrayList<String>()
                l.add(str)
                res.add(l)
            }
        }
        return res
    }

    private fun isAnagram(str1: String, str2: String): Boolean {
        if (str1.length != str2.length) return false
        val arr = IntArray(26)
        str1.forEach { arr[it - 'a']++ }
        str2.forEach { arr[it - 'a']-- }
        return arr.any { it > 0 }.not()
    }

    fun groupAnagrams2(strs: Array<String>): List<List<String>> {
        if (strs.isEmpty()) return ArrayList()
        val map: MutableMap<String, MutableList<String>> = HashMap()
        for (s in strs) {
            val ca = CharArray(26)
            for (c in s.toCharArray()) ca[c.code - 'a'.code]++
            val keyStr = String(ca)
            if (!map.containsKey(keyStr)) {
                map[keyStr] = ArrayList()
            }
            map[keyStr]!!.add(s)
        }
        return map.values.toList()
    }
}
