package com.example.moviltours

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.moviltours.databinding.ActivityMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CustomCap
import com.google.android.gms.maps.model.Dash
import com.google.android.gms.maps.model.Dot
import com.google.android.gms.maps.model.Gap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.google.android.gms.maps.model.RoundCap

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var binding: ActivityMapBinding

    private lateinit var map:GoogleMap

    private var lat: Double = 0.0
    private var lng: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnVolver.setOnClickListener { onBackPressed() }
        binding.btnTourSugerido.setOnClickListener { createPolyLines () }

        createFragment ()
    }

    private fun createPolyLines () {
        val polylineOptions = PolylineOptions ()

        polylineOptions.startCap(RoundCap ())
        polylineOptions.endCap (CustomCap (BitmapDescriptorFactory.fromResource(R.drawable.flag)))

        polylineOptions.pattern (listOf(Dot (), Gap (10f), Dash (50f), Gap(10f)))

        polylineOptions.width(25f)
        polylineOptions.color (ContextCompat.getColor(this, R.color.yellow))

        polylineOptions.add(LatLng(lat, lng))
        polylineOptions.add(LatLng(1.0, 1.0))

        val polyLine = map.addPolyline(polylineOptions)
    }

    private fun  createFragment () {
        val mapFragment: SupportMapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync (this)
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        map = googleMap!!

        createMarker()
    }

    private fun createMarker () {
        val coordinates = LatLng (lat, lng)

        val marker = MarkerOptions ().position (coordinates).title ("Título de ejemplo")

        map.addMarker(marker)

        map.animateCamera(CameraUpdateFactory.newLatLngZoom (coordinates, 16f), 10000, null)
    }
}