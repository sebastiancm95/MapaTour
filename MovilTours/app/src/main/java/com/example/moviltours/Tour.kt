package com.example.moviltours

data class Tour(
    val name: String,
    val latitude: Float,
    val longitude: Float,
    val price: String,
    val photo: String
) : java.io.Serializable