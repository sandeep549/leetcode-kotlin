package com.sk.set23

import java.util.*

class FoodRatings2353(
    foods: Array<String>,
    cuisines: Array<String>,
    ratings: IntArray
) {

    val cMap = HashMap<String, PriorityQueue<Food>>() // cuisine -> PQ of Food
    var nameFoodMap = HashMap<String, Food>() // food name -> Food

    init {
        for (i in foods.indices) {
            val curr = Food(foods[i], cuisines[i], ratings[i])
            cMap.putIfAbsent(cuisines[i], PriorityQueue { a: Food, b: Food ->
                if (b.rating == a.rating) a.name.compareTo(b.name) else b.rating - a.rating
            })
            val pq = cMap[cuisines[i]]!!
            pq.add(curr)
            nameFoodMap[foods[i]] = curr
        }
    }

    fun changeRating(foodName: String, newRating: Int) {
        val food = nameFoodMap[foodName]!!
        val pq = cMap[food.cuisine]!!
        pq.remove(food)
        food.rating = newRating
        pq.add(food)
    }

    fun highestRated(cuisine: String): String {
        return cMap[cuisine]!!.peek().name
    }

}

class Food(var name: String, var cuisine: String, var rating: Int)


