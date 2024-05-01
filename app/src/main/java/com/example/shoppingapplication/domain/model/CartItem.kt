package com.example.shoppingapplication.domain.model

data class CartItem(
    val id: Int,
    val shoppingItemId: Int,
    var quantity: Int
) {
    val name = shoppingItemsHardCoded.filter { it.id == shoppingItemId }[0].name
    val url = shoppingItemsHardCoded.filter { it.id == shoppingItemId }[0].url
}