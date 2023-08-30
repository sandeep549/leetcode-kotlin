package com.sk.z_ImportantCodeSnippet

private fun mapsInKotlin() {
    // inbuilt maps (non java maps, though needs clarification)
    /*1*/
    var immutableMap = mapOf<Int, Int>() // maintains insertion order, immutable
    /*2*/
    var mutableMap = mutableMapOf<Int, Int>() // maintains order, mutable

    // work with below 3 whenever possible
    // factory method for java maps
    /*3*/
    var sortedmap = sortedMapOf<Int, Int>() // java TreeMap, mutable
    /*4*/
    var hasmap = hashMapOf<Int, Int>() // java HashMap, mutable
    /*5*/
    var likedhashmap = linkedMapOf<Int, Int>() // java LinkedHashMap, mutable, same as 2 internally

    val m1 = mapOf(
        1 to 3,
        3 to 4
    )

    val m2 = mapOf(
        "hey" to 1,
        "hello" to 2
    )

}
