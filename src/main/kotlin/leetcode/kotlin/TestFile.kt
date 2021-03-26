package leetcode.kotlin

import java.util.ArrayList
import java.util.Collections
import java.util.Comparator

fun merge2(intervals: List<Interval>): List<Interval>? {
    Collections.sort(intervals,
        Comparator<Any> { obj0, obj1 -> obj0.start - obj1.start })
    val ret: MutableList<Interval> = ArrayList<Interval>()
    var prev: Interval? = null
    for (inter in intervals) {
        if (prev == null || inter.start > prev.end) {
            ret.add(inter)
            prev = inter
        } else if (inter.end > prev.end) {
            // Modify the element already in list
            prev.end = inter.end
        }
    }
    return ret
}

private fun merge(intervals: Array<IntArray>): Array<IntArray> {
}