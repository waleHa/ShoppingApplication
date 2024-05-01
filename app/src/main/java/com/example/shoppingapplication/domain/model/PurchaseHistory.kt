package com.example.shoppingapplication.domain.model

data class PurchaseHistory(
    val transactionId: Int,
    val items: List<ShoppingItem>,
    val purchaseDate: String,

){
    var totalAmount: Double = listOf(shoppingItems[0], shoppingItems[2]).sumOf {
        (it.price * it.quantity)
    }
}