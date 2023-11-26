package com.sk.topicWise.graph

class Solution433 {
    fun minMutation(startGene: String, endGene: String, bank: Array<String>): Int {
        val q = ArrayDeque<String>()
        q.addLast(startGene)
        val seen = HashSet<String>()
        seen.add(startGene)
        var steps = 0
        while (q.isNotEmpty()) {
            var size = q.size
            while (size-- > 0) {
                val gene = q.removeFirst()
                if (gene == endGene) return steps
                for (next in bank) {
                    if (seen.contains(next)) continue
                    if (isNextMutation(gene, next)) {
                        q.add(next)
                        seen.add(next)
                    }
                }
            }
            steps++
        }
        return -1
    }

    private fun isNextMutation(gene: String, next: String): Boolean {
        var d = 0
        for (i in gene.indices) {
            if (gene[i] != next[i]) d++
        }
        return d == 1
    }
}