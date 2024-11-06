package com.sk.set13

class Solution1356 {
    fun sortByBits(arr: IntArray): IntArray {
        return arr.sortedWith(Comparator { o1, o2 ->
            val b1 = o1.countOneBits()
            val b2 = o2.countOneBits()
            if (b1 == b2) o1.compareTo(o2)
            else b1.compareTo(b2)
        }).toIntArray()

//        arr.toTypedArray().sortWith(Comparator { o1, o2 ->
//            val b1 = o1.countOneBits()
//            val b2 = o2.countOneBits()
//            if (b1 == b2) o1.compareTo(o2)
//            else b1.compareTo(b2)
//        })
//        return arr
//    }
    }
}
