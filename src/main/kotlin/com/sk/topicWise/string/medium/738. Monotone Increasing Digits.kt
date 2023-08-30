package com.sk.topicWise.string.medium

private fun monotoneIncreasingDigits(N: Int): Int {
    //1. Convert the given integer to character array
    val ch = N.toString().toCharArray()

    //2. Create a integer mark variable and initialize it to the length of the character array
    var mark = ch.size

    //3. Iterate from the end of the array to the beginning of the array.
    //Everytime you find current digit less then previous digit, reduce the previous digit by 1 and set that digit as the mark
    for (i in ch.size - 1 downTo 1) {
        if (ch[i] < ch[i - 1]) {
            mark = i - 1
            ch[i - 1]--
        }
    }

    //4. Set all digits after mark to 9 as we want the highest number.
    //In step 3 we made sure that all digits before mark are in increasing order
    for (i in mark + 1 until ch.size) {
        ch[i] = '9'
    }
    return String(ch).toInt()
}
