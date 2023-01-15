package topicWise.unionfind

internal class Solution1061 {
    var representative = IntArray(26)

    // Returns the root representative of the component.
    fun find(x: Int): Int {
        return if (representative[x] == x) {
            x
        } else {
            find(representative[x]).also { representative[x] = it }
        }
    }

    // Perform union if x and y aren't in the same component.
    fun performUnion(x: Int, y: Int) {
        val xr = find(x)
        val yr = find(y)
        if (xr == yr) {
            return
        }

        // Make the smaller character representative.
        if (xr < yr) {
            representative[yr] = xr
        } else {
            representative[xr] = yr
        }
    }

    fun smallestEquivalentString(s1: String, s2: String, baseStr: String): String {
        // Make each character representative of itself.
        for (i in 0..25) {
            representative[i] = i
        }

        // Perform union merge for all the edges.
        for (i in s1.indices) {
            performUnion(s1[i].code - 'a'.code, s2[i].code - 'a'.code)
        }
        var ans = ""
        // Create the answer string with final mappings.
        for (c in baseStr.toCharArray()) {
            ans += (find(c.code - 'a'.code) + 'a'.code).toChar()
        }
        return ans
    }
}
