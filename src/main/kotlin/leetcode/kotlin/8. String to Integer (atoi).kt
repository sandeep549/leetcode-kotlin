package leetcode.kotlin

private fun myAtoi(str: String): Int {
    var i = 0
    var sign = 1
    var result = 0
    if (str.length == 0) return 0

    //Discard whitespaces in the beginning
    while (i < str.length && str[i] == ' ') i++

    // Check if optional sign if it exists
    if (i < str.length && (str[i] == '+' || str[i] == '-')) sign = if (str[i++] == '-') -1 else 1

    // Build the result and check for overflow/underflow condition
    while (i < str.length && str[i] >= '0' && str[i] <= '9') {
        if (result > Int.MAX_VALUE / 10 ||
            result == Int.MAX_VALUE / 10 && str[i] - '0' > Int.MAX_VALUE % 10
        ) {
            return if (sign == 1) Int.MAX_VALUE else Int.MIN_VALUE
        }
        result = result * 10 + (str[i++] - '0')
    }
    return result * sign
}