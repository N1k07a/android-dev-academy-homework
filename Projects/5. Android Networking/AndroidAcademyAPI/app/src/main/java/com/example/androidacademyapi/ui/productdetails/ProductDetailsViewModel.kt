package com.example.androidacademyapi.ui.productdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidacademyapi.data.repository.ProductRepository
import com.example.androidacademyapi.ui.productlistscreen.ProductListViewModel

class ProductDetailsViewModel(
    private val repository: ProductRepository,
    private val productId: Int
) : ViewModel() {

}

class ProductDetailsViewModelFactory(
    private val repository: ProductRepository,
    private val productId: Int
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductDetailsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProductDetailsViewModel(repository,productId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}