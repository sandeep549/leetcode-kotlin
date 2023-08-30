package com.sk.topicWise.string.easy

private fun reformatDate(date: String): String {
    var di = date.indexOf("st")
    if (di < 0) di = date.indexOf("nd")
    if (di < 0) di = date.indexOf("rd")
    if (di < 0) di = date.indexOf("th")
    val dd = date.substring(0, di)
    val map = mapOf(
        "Jan" to "01",
        "Feb" to "02",
        "Mar" to "03",
        "Apr" to "04",
        "May" to "05",
        "Jun" to "06",
        "Jul" to "07",
        "Aug" to "08",
        "Sep" to "09",
        "Oct" to "10",
        "Nov" to "11",
        "Dec" to "12"
    )
    val mmString = date.substring(date.indexOf(" ") + 1, date.lastIndexOf(" "))
    println(map.toList())
    return date.substring(date.lastIndexOf(" ") + 1) + "-" + map[mmString] + "-" +
        dd.padStart(2, '0')
}
