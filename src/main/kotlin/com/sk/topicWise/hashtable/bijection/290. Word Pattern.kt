package com.sk.topicWise.hashtable.bijection

class Solution290 {
    fun wordPattern(pattern: String, s: String): Boolean {
        val chars = pattern.toCharArray()
        val words = s.split(" ")
        if (chars.size != words.size) return false

        val map = HashMap<Char, String>()
        val set = HashSet<String>()

        for (i in chars.indices) {
            if (map.containsKey(chars[i])) {
                if (map[chars[i]] != words[i]) return false
            } else {
                if (set.contains(words[i])) return false
                map[chars[i]] = words[i]
                set.add(words[i])
            }
        }
        return true
    }
}

//####################################################################
// BijectionMap
//####################################################################

class BijectionMap<K, V>() {
    private val forward = HashMap<K, V>()
    private val backward = HashMap<V, K>()

    fun put(k: K, v: V): Boolean {
        if (forward.containsKey(k)) return false
        if (backward.containsKey(v)) return false
        forward[k] = v
        backward[v] = k
        return true
    }

    fun containsForward(k: K) = forward.containsKey(k)

    fun forward(k: K) = forward[k]

    fun containsBackward(v: V) = backward.containsKey(v)

    fun backward(v: V) = backward[v]
}

//####################################################################

class Solution290_2 {
    fun wordPattern(pattern: String, s: String): Boolean {
        val chars = pattern.toCharArray()
        val words = s.split(" ")
        if (chars.size != words.size) return false

        val bijection = BijectionMap<Char, String>()
        for (i in chars.indices) {
            val ch = chars[i]
            val word = words[i]
            if (bijection.containsForward(ch) && bijection.forward(ch) != word) return false
            if (bijection.containsBackward(word) && bijection.backward(word) != ch) return false
            bijection.put(ch, word)
        }
        return true
    }
}
