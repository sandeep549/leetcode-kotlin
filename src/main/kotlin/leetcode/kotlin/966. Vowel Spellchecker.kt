package leetcode.kotlin

private fun spellchecker(wordlist: Array<String>, queries: Array<String?>): Array<String?> {
    val exactSet = mutableSetOf<String>()
    val capMap = mutableMapOf<String, String>()
    val vowelMap = mutableMapOf<String, String>()
    for (word in wordlist) {
        val lower = word.toLowerCase()
        val devowel = lower.replace("[aeiou]".toRegex(), "*")
        exactSet.add(word)
        capMap.putIfAbsent(lower, word)
        vowelMap.putIfAbsent(devowel, word)
    }
    for (i in queries.indices) {
        if (exactSet.contains(queries[i])) continue
        val lower = queries[i]!!.toLowerCase()
        val devowel = lower.replace("[aeiou]".toRegex(), "*")
        if (capMap.containsKey(lower)) {
            queries[i] = capMap[lower]
        } else if (vowelMap.containsKey(devowel)) {
            queries[i] = vowelMap[devowel]
        } else {
            queries[i] = ""
        }
    }
    return queries
}