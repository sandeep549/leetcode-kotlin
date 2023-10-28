package com.sk.topicWise.bitManipulation

class Solution190 {
    fun reverseBits(n: Int): Int {
        var no = n
        var result = 0
        repeat(32) {
            result = result shl 1
            if (no and 1 == 1) {
                result++
            }
            no = no shr 1
        }
        return result
    }

    fun reverseBits2(n: Int): Int {
        var num = n
        num = num and 0xffff0000.toInt() ushr 16 or (num and 0x0000ffff.toInt() shl 16)
        num = num and 0xff00ff00.toInt() ushr 8 or (num and 0x00ff00ff.toInt() shl 8)
        num = num and 0xf0f0f0f0.toInt() ushr 4 or (num and 0x0f0f0f0f.toInt() shl 4)
        num = num and 0xcccccccc.toInt() ushr 2 or (num and 0x33333333.toInt() shl 2)
        num = num and 0xaaaaaaaa.toInt() ushr 1 or (num and 0x55555555.toInt() shl 1)

        return num
    }
}


// private fun test(n: Int) : Int {
//     var n = n
//     n = n.shr(16).or(n.shl(16))
//     n = n.and(-0xff0100).shr(8).or(n.and(0x00ff00ff).shl(8))
//     n = n.and(-0xf0f0f10).shr(4).or(n.and(0x0f0f0f0f).shl(4))
//     n = n.and(-0x33333334).shr(2).or(n.and(0x33333333).shl(2))
//     n = n.and(-0x55555556).shr(1).or(n.and(0x55555555).shl(1))
//     return n
// }


// fun main() {
//    println(0xffff0000.toInt())
//    println(0x0000ffff.toInt())
//
//    println(0xff00ff00.toInt())
//    println(0x00ff00ff.toInt())
//
//    println(0xff00.toInt())
//    println(0x00ff.toInt())
//
//    println(0xff.toInt())
//    println(0x00.toInt())
// }

// TODO: 16/2/21 kotlin hexadecimal problem
// https://youtrack.jetbrains.com/issue/KT-2780
//https://youtrack.jetbrains.com/issue/KT-4749