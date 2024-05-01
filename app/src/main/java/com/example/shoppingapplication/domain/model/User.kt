package com.example.shoppingapplication.domain.model

data class User(
    val userName: String,
    val fullName: String,
    val location: String,
    val joinDate: String,
    val description: String,
    val websiteUrl: String,
    val email: String,
    val phoneNumber: String
)