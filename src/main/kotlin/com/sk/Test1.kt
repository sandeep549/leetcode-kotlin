package com.sk
// Google Interview Question

private data class Range(val label: String, val start: Int, val end: Int)
private data class MergedRange(val start: Int, val end: Int, val labels: List<String>)

private fun mergeAndLabelRanges(ranges: List<Range>): List<MergedRange> {
    // Create events for the sweep line algorithm
    val events = mutableListOf<Triple<Int, String, String>>() // (position, type, label)
    for (range in ranges) {
        events.add(Triple(range.start, "start", range.label))
        events.add(Triple(range.end, "end", range.label))
    }

    // Sort events by position, prioritizing "start" over "end" in case of ties
    events.sortWith(compareBy({ it.first }, { it.second == "end" }))

    val activeLabels = mutableSetOf<String>()
    val result = mutableListOf<MergedRange>()
    var prevPosition: Int? = null

    for ((position, type, label) in events) {
        if (prevPosition != null && position != prevPosition) {
            if (activeLabels.isNotEmpty()) {
                result.add(MergedRange(prevPosition, position, activeLabels.sorted()))
            }
        }

        when (type) {
            "start" -> activeLabels.add(label)
            "end" -> activeLabels.remove(label)
        }

        prevPosition = position
    }

    return result
}

// Example usage
//fun main() {
//    val ranges = listOf(
//        Range("A", 1, 5),
//        Range("B", 4, 9),
//        Range("C", 10, 15)
//    )
//
//    val output = mergeAndLabelRanges(ranges)
//    for (range in output) {
//        println("Range: [${range.start}, ${range.end}) => Labels: ${range.labels}")
//    }
//}