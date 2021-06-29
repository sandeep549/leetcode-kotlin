package leetcode.kotlin.array.easy

private fun generate(numRows: Int): List<List<Int>> {
    val list = ArrayList<List<Int>>()
    for (row in 1..numRows) {
        val currow = ArrayList<Int>()
        for (item in 1..row) {
            if (item == 1 || item == row) {
                currow.add(1)
            } else {
                currow.add(list.get(row - 2).get(item - 2) + list.get(row - 2).get(item - 1))
            }
        }
        list.add(currow)
    }
    return list
}
