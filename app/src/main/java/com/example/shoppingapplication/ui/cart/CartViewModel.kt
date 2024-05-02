package com.example.shoppingapplication.ui.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppingapplication.domain.model.CartItem
import com.example.shoppingapplication.domain.model.cartItemsHardCoded

class CartViewModel : ViewModel() {

    private val _cartItems = MutableLiveData<List<CartItem>>(cartItemsHardCoded)

    val cartItems: LiveData<List<CartItem>> = _cartItems

    fun increaseQuantity(cartItem: CartItem) {
        _cartItems.value = _cartItems.value?.map {
            if (it.id == cartItem.id)
                it.copy(quantity = it.quantity + 1)
            else it
        }
    }
}
