package com.sk.topicWise.slidingwindow.hard

class Solution76 {
    fun minWindow(s: String, t: String): String {
        if (s.length < t.length) return ""
        val dict = t.toCharArray().groupBy { it }.mapValues { it.value.size }.toMutableMap()
        val required = dict.size
        var l = 0
        var r = 0
        var formed = 0
        val windowCounts = HashMap<Char, Int>()
        var ans = Pair(0, s.length + 1)
        while (r < s.length) { // Add one character from the right to the window
            var c = s[r]
            windowCounts[c] = windowCounts.getOrDefault(c, 0) + 1
            if (dict.containsKey(c) && windowCounts[c]!! == dict[c]!!) {
                formed++
            }
            while (l <= r && formed == required) {
                if (r - l < ans.second - ans.first) {
                    ans = Pair(l, r) // save new smallest window
                }
                c = s[l]
                windowCounts[c] = windowCounts[c]!! - 1
                if (dict.containsKey(c) && windowCounts[c]!! < dict[c]!!) {
                    formed--
                }
                l++
            }
            r++
        }
        return if (ans.second - ans.first > s.length) "" else s.substring(ans.first, ans.second + 1)
    }

    fun minWindow2(s: String, t: String): String {
        val map = t.toCharArray().groupBy { it }.mapValues { it.value.size }.toMutableMap()
        var l = 0
        var r = 0
        var start = 0
        var distance = Int.MAX_VALUE
        var counter = t.length

        while (r < s.length) {
            val c1 = s[r]
            if (map.contains(c1)) {
                if (map[c1]!! > 0) counter--
                map[c1] = map[c1]!! - 1
            }
            r++

            while (counter == 0) {
                if (distance > r - l) {
                    distance = r - l
                    start = l
                }
                val c2 = s[l]
                if (map.contains(c2)) {
                    map[c2] = map[c2]!! + 1
                    if (map[c2]!! > 0) counter++
                }
                l++
            }
        }
        return if (distance == Int.MAX_VALUE) "" else s.substring(start, start + distance)
    }

}
