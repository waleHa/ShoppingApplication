package com.example.shoppingapplication.data.api

import com.example.shoppingapplication.domain.model.ShoppingItem
import retrofit2.http.GET

interface ApiEndpoints {

    @GET(ApiDetail.PRODUCT_ENDPOINT)
    suspend fun getProducts(): List<ShoppingItem>

}