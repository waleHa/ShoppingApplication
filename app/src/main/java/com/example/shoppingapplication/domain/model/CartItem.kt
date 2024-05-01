package com.example.shoppingapplication.domain.model

data class CartItem(
    val id: Int,
    val shoppingItemId: Int,
    val quantity: Int
) {
    val name = shoppingItems.filter { it.id == shoppingItemId }[0].name
}