package com.example.shoppingapplication.ui.shoppinglist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppingapplication.domain.model.ShoppingItem
import com.example.shoppingapplication.domain.model.shoppingItemsHardCoded
import androidx.lifecycle.viewModelScope
import com.example.shoppingapplication.data.api.RetrofitInstance


class ShoppingListViewModel : ViewModel() {

    val shoppingItems: LiveData<List<ShoppingItem>> = MutableLiveData(shoppingItemsHardCoded,)
}
private fun getProducts():List<ShoppingItem> {
    viewModelScope.launch {
        val result = RetrofitInstance.apiClient.getProducts()
        if (!result.isNullOrEmpty())
            result
    }
}