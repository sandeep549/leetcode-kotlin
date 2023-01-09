package model

/**
 * N-ary tree node
 */
class NTreeNode(var `val`: Int) {
    constructor(`val`: Int, children: ArrayList<NTreeNode>?) : this(`val`) {
        this.children = children
    }

    var children: ArrayList<NTreeNode>? = null
}


