package com.example.shoppingapplication.domain.model


import com.google.gson.annotations.SerializedName

data class Rating(
    @SerializedName("count")
    val countModel: Int? = 0,
    @SerializedName("rate")
    val rateModel: Double? = 0.0
)