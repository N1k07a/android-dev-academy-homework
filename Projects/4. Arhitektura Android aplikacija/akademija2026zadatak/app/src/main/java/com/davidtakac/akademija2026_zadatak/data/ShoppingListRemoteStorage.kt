package com.davidtakac.akademija2026_zadatak.data

import com.davidtakac.akademija2026_zadatak.model.ShoppingListItem
import kotlinx.coroutines.delay
import kotlin.random.Random
import kotlin.random.nextLong

class ShoppingListRemoteStorage {
    private val list = mutableListOf(
        ShoppingListItem("Milk"),
        ShoppingListItem("Cereal"),
        ShoppingListItem("Cat Food"),
        ShoppingListItem("Flaming Hot Cheetos"),
        ShoppingListItem("Cheese")
    )

    suspend fun getList(): List<ShoppingListItem> {
        simulateNetworkCommunication()
        return list
    }

    suspend fun save(item: ShoppingListItem) {
        simulateNetworkCommunication()
        val indexOfItem = list.indexOfFirst { it.name == item.name }
        list[indexOfItem] = item
    }

    private suspend fun simulateNetworkCommunication() {
        delay(Random.nextLong(300L..800L))
        if (Random.nextInt(0, 10) > 8) {
            throw Exception("Oops!")
        }
    }
}