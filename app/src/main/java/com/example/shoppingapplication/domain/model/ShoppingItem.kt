package com.example.shoppingapplication.domain.model

data class ShoppingItem(
    val id: Int,
    val name: String,
    val price: Double,
    val quantity: Int,
    val categoryId: Int,
    val url:String
)