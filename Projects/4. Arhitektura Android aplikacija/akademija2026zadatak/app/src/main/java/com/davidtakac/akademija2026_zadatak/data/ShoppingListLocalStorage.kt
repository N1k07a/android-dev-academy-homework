package com.davidtakac.akademija2026_zadatak.data

import com.davidtakac.akademija2026_zadatak.model.ShoppingListItem
import kotlinx.coroutines.delay
import kotlin.random.Random
import kotlin.random.nextLong

class ShoppingListLocalStorage {
    private lateinit var list: MutableList<ShoppingListItem>

    suspend fun getList(): List<ShoppingListItem>? {
        simulateDiskIO()
        return if (::list.isInitialized) list else null
    }

    suspend fun saveList(list: List<ShoppingListItem>) {
        simulateDiskIO()
        this.list = list.toMutableList()
    }

    suspend fun save(item: ShoppingListItem) {
        simulateDiskIO()
        if (!::list.isInitialized) {
            list = mutableListOf()
        }

        val indexOfItem = list.indexOf(item)
        if (indexOfItem >= 0) {
            list[indexOfItem] = item
        } else {
            list.add(item)
        }
    }

    private suspend fun simulateDiskIO() {
        delay(Random.nextLong(5L..50L))
    }
}
