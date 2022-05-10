package com.example.moviltours.Tour

import com.google.android.gms.maps.model.LatLng

data class Tour(
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val price: String,
    val photo: String,
    val travel: List<LatLng>
) : java.io.Serializable