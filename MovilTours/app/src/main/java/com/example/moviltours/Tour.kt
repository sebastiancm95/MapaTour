package com.example.moviltours

data class Tour(
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val price: String,
    val photo: String
) : java.io.Serializable