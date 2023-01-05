
class Solution2244 {
    fun minimumRounds(tasks: IntArray): Int {
        val count: HashMap<Int, Int> = HashMap()
        for (a in tasks) {
            count[a] = count.getOrDefault(a, 0) + 1
        }
        var res = 0
        for (freq in count.values) {
            if (freq == 1) return -1
            res += (freq + 2) / 3
        }
        return res
    }
}
