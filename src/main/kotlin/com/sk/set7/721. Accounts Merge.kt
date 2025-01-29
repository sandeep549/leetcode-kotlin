package com.sk.set7

class Solution721 {

    // UnionFind
    class DSU(sz: Int) {
        private val representative = IntArray(sz) { it }
        private val size = IntArray(sz) { 1 }

        // Finds the representative of group x
        fun findRepresentative(x: Int): Int {
            if (x == representative[x]) {
                return x
            }
            // Path compression
            representative[x] = findRepresentative(representative[x])
            return representative[x]
        }

        // Unite the group that contains "a" with the group that contains "b"
        fun unionBySize(a: Int, b: Int): Boolean {
            val repA = findRepresentative(a)
            val repB = findRepresentative(b)

            // If nodes a and b already belong to the same group, do nothing.
            if (repA == repB) return false

            // Union by size: point the representative of the smaller group to the larger one
            if (size[repA] >= size[repB]) {
                size[repA] += size[repB]
                representative[repB] = repA
            } else {
                size[repB] += size[repA]
                representative[repA] = repB
            }
            return true
        }
    }

    fun accountsMerge(accountList: List<List<String>>): List<List<String>> {
        val accountListSize = accountList.size
        val dsu = DSU(accountListSize)

        // Maps email to their component index
        val emailToGroupMap = mutableMapOf<String, Int>()

        for (i in 0 until accountListSize) {
            for (j in 1 until accountList[i].size) {
                val email = accountList[i][j]

                // If this is the first time seeing this email, assign component group as the account index
                emailToGroupMap[email]?.let {
                    dsu.unionBySize(i, it)
                } ?: run {
                    emailToGroupMap[email] = i
                }
            }
        }

        // Store emails corresponding to the component's representative
        val representativeToEmailListMap = mutableMapOf<Int, MutableList<String>>()
        for ((email, group) in emailToGroupMap) {
            val groupRep = dsu.findRepresentative(group)
            representativeToEmailListMap.computeIfAbsent(groupRep) { mutableListOf() }.add(email)
        }

        // Sort the components and add the account name
        val mergedAccounts = mutableListOf<List<String>>()
        for ((representative, emailList) in representativeToEmailListMap) {
            emailList.sort()
            mergedAccounts.add(listOf(accountList[representative][0]) + emailList)
        }

        return mergedAccounts
    }

}