package com.example.shoppingapplication.ui.shoppinglist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppingapplication.domain.model.ShoppingItem
import com.example.shoppingapplication.domain.model.shoppingItemsHardCoded

class ShoppingListViewModel : ViewModel() {
    val shoppingItems: LiveData<List<ShoppingItem>> = MutableLiveData(shoppingItemsHardCoded)
}