package leetcode.google

private val messageSet = mutableSetOf<String>()
private val deque = ArrayDeque<Pair<String, Int>>() // keep last 10 latest messages in time
fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
    if (messageSet.contains(message)) return false
    deque.add(Pair(message, timestamp))
    if (deque.size > 10) {
        messageSet.remove(deque.first().first)
        deque.removeFirst()
    }
    return true
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