package com.davidtakac.akademija2026_zadatak.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.davidtakac.akademija2026_zadatak.model.GetListResult
import com.davidtakac.akademija2026_zadatak.model.ShoppingListItem
import com.davidtakac.akademija2026_zadatak.model.ShoppingListRepository
import com.davidtakac.akademija2026_zadatak.model.ToggleResult
import com.davidtakac.akademija2026_zadatak.model.shoppingListRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ShoppingListViewModel(private val repository: ShoppingListRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<ShoppingListUiState>(ShoppingListUiState.Loading)
    val uiState = _uiState.asStateFlow()

    fun getList() {
        viewModelScope.launch {
            _uiState.value = ShoppingListUiState.Loading
            _uiState.value = when (val result = repository.getList()) {
                is GetListResult.Success -> ShoppingListUiState.Loaded(list = result.list)
                GetListResult.Failure -> ShoppingListUiState.Failure("Error! Try again.")
            }
        }
    }

    fun toggle(item: ShoppingListItem) {
        viewModelScope.launch {
            var currentState = _uiState.value as? ShoppingListUiState.Loaded
                ?: throw IllegalStateException()

            currentState = currentState.copy(toggling = true)
            _uiState.value = currentState

            currentState = when (val result = repository.toggle(item)) {
                is ToggleResult.Success -> currentState.copy(
                    list = currentState.list.map { if (it == item) result.toggledItem else it },
                    toggling = false
                )
                ToggleResult.Failure -> currentState.copy(toggling = false)
            }
            _uiState.value = currentState
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T =
                ShoppingListViewModel(shoppingListRepository) as T
        }
    }
}

sealed interface ShoppingListUiState {
    data class Loaded(
        val list: List<ShoppingListItem>,
        val toggling: Boolean = false,
    ) : ShoppingListUiState
    data object Loading : ShoppingListUiState
    data class Failure(val message: String) : ShoppingListUiState
}
