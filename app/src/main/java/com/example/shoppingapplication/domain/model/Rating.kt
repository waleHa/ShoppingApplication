package com.example.shoppingapplication.domain.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Rating(
    @SerializedName("count")
    val count: Int? = 0,
    @SerializedName("rate")
    val rateAverage: Double? = 0.0
):Parcelable