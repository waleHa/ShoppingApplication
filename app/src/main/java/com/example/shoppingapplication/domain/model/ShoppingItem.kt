package com.example.shoppingapplication.domain.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ShoppingItem(
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("title")
    val name: String? = "",
    @SerializedName("price")
    val price: Double? = 0.0,
    var quantity: Int = 100,
    @SerializedName("category")
    val category: String? = "", //Need to handle categoryId
    @SerializedName("image")
    val url: String? = "",

    @SerializedName("description")
    val descriptionModel: String? = "",

    @SerializedName("rating")
    val ratingModel: Rating? = Rating(),
):Parcelable