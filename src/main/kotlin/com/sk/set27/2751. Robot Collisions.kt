package com.sk.set27

private class Robot(val position: Int, var health: Int, val direction: Char)

class Solution {
    fun survivedRobotsHealths(positions: IntArray, healths: IntArray, directions: String): List<Int> {
        val positionToIndexMap = mutableMapOf<Int, Int>()
        positions.forEachIndexed { index, position ->  positionToIndexMap[position] = index    }


        val robotList = mutableListOf<Robot>()
        positions.forEachIndexed { index, position ->
            robotList.add(Robot(position, healths[index], directions[index]))
        }
        robotList.sortWith { robot1, robot2 ->
            robot1.position.compareTo(robot2.position)
        }
        val stack = ArrayDeque<Robot>()
        robotList.forEach { robot ->
            if (stack.isNotEmpty() && stack.last().direction == 'R' && robot.direction == 'L') {
                when {
                    stack.last().health == robot.health -> {
                        // both destroyed
                        stack.removeLast()
                    }
                    stack.last().health > robot.health -> {
                        // Right destroyed
                        stack.last().health -= 1
                    }
                    else -> {
                        while (stack.isNotEmpty() && stack.last().direction == 'R') {
                            if (stack.last().health < robot.health) {
                                stack.removeLast()
                                robot.health -= 1
                            } else if (stack.last().health > robot.health) {
                                stack.last().health -= 1
                                robot.health = 0
                                break
                            } else {
                                stack.removeLast()
                                robot.health = 0
                                break // both destroyed
                            }
                        }
                        if (robot.health != 0) stack.addLast(robot)
                    }
                }
            } else {
                stack.addLast(robot)
            }
        }
        stack.sortWith { robot1, robot2 ->
            positionToIndexMap[robot1.position]!!.compareTo(positionToIndexMap[robot2.position]!!)
        }
        return stack.map { it.health }
    }
}
