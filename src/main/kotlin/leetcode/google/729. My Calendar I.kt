package leetcode.google

import java.util.TreeMap

class Meeting(val s: Int, val e: Int)

class MyCalendar() {

    val meetings = TreeMap<Int, Int>()
    fun book(start: Int, end: Int): Boolean {
        val pre = meetings.floorEntry(start)
        if(pre != null && start < pre.value ) { // overlap with previous
            return false
        }
        val next = meetings.higherEntry(start)
        if(next != null && next.key < end) { // overlap with next
            return false
        }
        meetings[start] = end
        return true
    }

}