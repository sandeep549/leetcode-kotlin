package leetcode.kotlin.z_ImportantCodeSnippet

private fun listInKotlin() {
    // 1
    var l1 = listOf<Int>() // read-only, random access like ArrayList
    // 2
    var l2 = mutableListOf<Int>() // mutable, random access like ArrayList
    // work with above 2 whenever possible

    // 3
    var l3 = arrayListOf<Int>() // same as 2, mutable ArrayList
    var l4 = emptyList<Int>() // read-only, random access
    var l5 = listOfNotNull<Int>() // read-only, random access

    val l6 = listOf(1, 2, 3)
    val l7 = listOf("hi", "hello")


    // No sequential access list in kotlin ???
}
