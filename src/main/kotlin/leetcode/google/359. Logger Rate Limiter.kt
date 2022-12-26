package leetcode.google

private val messageMap = mutableMapOf<String, Int>()
fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
    if (!messageMap.containsKey(message) || timestamp - messageMap[message]!! >= 10) {
        messageMap[message] = timestamp
        return true
    }
    messageMap.entries.removeIf { timestamp - it.value >= 10}
    return false
}


private class Logger {

    var map = object : LinkedHashMap<String, Int>(100, 0.6f, true) {
        override fun removeEldestEntry(eldest: Map.Entry<String?, Int>): Boolean {
            return time - eldest.value > 10
        }
    }

    var time = 0

    fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
        time = timestamp
        if (!map.containsKey(message) || timestamp - map[message]!! >= 10) {
            map[message] = timestamp
            return true
        }
        return false
    }
}
