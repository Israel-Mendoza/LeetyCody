package dev.artisra.topinterview150.arraystring

class RandomizedSet {

    private val elementMap = mutableMapOf<Int, Int>()
    private val elementList = mutableListOf<Int>()

    fun insert(value: Int): Boolean {
        // The value must not exist, so we can add it.
        if (value in elementMap) return false

        elementMap[value] = elementList.size
        elementList.add(value)

        return true
    }

    fun remove(value: Int): Boolean {
        // The value must exist, so we can remove it.
        if (value !in elementMap) return false

        // Getting the index of the element we will remove.
        val index = elementMap[value]!!

        // THE CURRENT LAST ITEM WILL TAKE THE PLACE OF THE ITEM WE WANT TO REMOVE.

        // Removing from the map.
        elementMap[elementList.last()] = index // Updating the index of the last item.
        elementMap.remove(value)

        // Removing from the list
        elementList[index] = elementList.last() // Moving the item to the current index.
        elementList.removeLast()

        return true
    }

    // More idiomatic in Kotlin.
    // Otherwise, we would write some boilerplate code to access a random index in the list.
    fun getRandom(): Int = elementList.random()
}