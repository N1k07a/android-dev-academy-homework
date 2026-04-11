package com.davidtakac.akademija2026_zadatak.model

import com.davidtakac.akademija2026_zadatak.data.ShoppingListLocalStorage
import com.davidtakac.akademija2026_zadatak.data.ShoppingListRemoteStorage

val shoppingListRepository by lazy {
    ShoppingListRepository(
        localStorage = ShoppingListLocalStorage(),
        remoteStorage = ShoppingListRemoteStorage(),
    )
}

class ShoppingListRepository(
    private val localStorage: ShoppingListLocalStorage,
    private val remoteStorage: ShoppingListRemoteStorage,
) {
    suspend fun toggle(item: ShoppingListItem): ToggleResult {
        val toggledItem = item.copy(completed = !item.completed)
        try {
            remoteStorage.save(toggledItem)
        } catch (_: Exception) {
            return ToggleResult.Failure
        }
        localStorage.save(toggledItem)
        return ToggleResult.Success(toggledItem)
    }

    suspend fun getList(): GetListResult {
        localStorage.getList()?.let { return GetListResult.Success(it) }

        val remoteList = try {
            remoteStorage.getList()
        } catch (_: Exception) {
            return GetListResult.Failure
        }

        localStorage.saveList(remoteList)
        return GetListResult.Success(remoteList)
    }
}

sealed interface ToggleResult {
    data class Success(val toggledItem: ShoppingListItem) : ToggleResult
    data object Failure : ToggleResult
}

sealed interface GetListResult {
    data class Success(val list: List<ShoppingListItem>) : GetListResult
    data object Failure : GetListResult
}
