package leetcode.kotlin.array.easy

import java.util.PriorityQueue


private fun minMeetingRooms(intervals: Array<IntArray>): Int {
    intervals.sortBy { it[0] }
    var pq = PriorityQueue<IntArray>() { a1, a2 -> a1[1] - a2[1] } // sort by end time
    for (meeting in intervals) {
        if (!pq.isEmpty() && pq.peek()[1] <= meeting[0]) pq.poll() // notice equal, we are not counting swapping time
        pq.add(meeting)
    }
    return pq.size
}

private fun minMeetingRooms2(intervals: Array<IntArray>): Int {
    val starts = IntArray(intervals.size)
    val ends = IntArray(intervals.size)
    intervals.forEachIndexed { index, interval ->
        starts[index] = interval[0]
        ends[index] = interval[1]
    }
    starts.sort()
    ends.sort()

    var rooms = 0
    var endsItr = 0
    for (i in starts.indices) {
        if (starts[i] < ends[endsItr]) {
            rooms++
        } else {
            endsItr++
        }
    }
    return rooms
}

private fun minMeetingRooms3(intervals: Array<IntArray>): Int {
    val time = mutableListOf<Pair<Int, Boolean>>()
    intervals.forEach {
        time.add(Pair(it[0], true))
        time.add(Pair(it[1], false))
    }
    // Notice sort, there can we same start and end point, put start point first
    time.sortWith(compareBy<Pair<Int, Boolean>> { it.first }.thenBy { it.second })

    var runningMeeting = 0 // running meeting at any time
    var maxRooms = 0
    for (pair in time) {
        if (pair.second) { //start time, allocate room
            runningMeeting++
            maxRooms = maxOf(maxRooms, runningMeeting)
        } else {
            runningMeeting--
        }
    }
    return maxRooms
}
