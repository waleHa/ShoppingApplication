package com.example.shoppingapplication.ui.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppingapplication.domain.model.Category
import com.example.shoppingapplication.domain.model.categoriesHardCoded

class CategoryViewModel : ViewModel() {
    val categories: LiveData<List<Category>> = MutableLiveData(categoriesHardCoded)
}