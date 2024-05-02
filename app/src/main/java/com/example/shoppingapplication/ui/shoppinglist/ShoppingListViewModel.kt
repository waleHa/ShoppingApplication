package com.example.shoppingapplication.ui.shoppinglist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppingapplication.domain.model.ShoppingItem
import com.example.shoppingapplication.domain.model.shoppingItemsHardCoded
import androidx.lifecycle.viewModelScope
import com.example.shoppingapplication.data.api.RetrofitInstance
import kotlinx.coroutines.launch


class ShoppingListViewModel : ViewModel() {

    private val _shoppingItems: MutableLiveData<List<ShoppingItem>> = MutableLiveData()

    // Exposed as LiveData for observing changes from UI
    val shoppingItems: LiveData<List<ShoppingItem>> = _shoppingItems

    init {
        loadProducts()
    }

    private fun loadProducts() {
        viewModelScope.launch {
            val products = RetrofitInstance.apiClient.getProducts()
            _shoppingItems.postValue(products)
        }
    }
}

