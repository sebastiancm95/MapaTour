package com.example.moviltours

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.moviltours.databinding.ActivityMapBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

class MapActivity : AppCompatActivity(), OnMapReadyCallback {

    companion object {
        val tour_name = "tour passed"
    }

    private lateinit var binding: ActivityMapBinding
    private lateinit var map: GoogleMap
    private lateinit var _tour: Tour

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnVolver.setOnClickListener { onBackPressed() }
        binding.btnTourSugerido.setOnClickListener { createPolyLines() }
        _tour = intent.getSerializableExtra(Test.tour_name) as Tour
        createFragment()
    }

    private fun createPolyLines() {
        val polylineOptions = PolylineOptions()
        polylineOptions.startCap(RoundCap())
        polylineOptions.endCap(CustomCap(BitmapDescriptorFactory.fromResource(R.drawable.flag)))
        polylineOptions.pattern(listOf(Dot(), Gap(10f), Dash(50f), Gap(10f)))
        polylineOptions.width(25f)
        polylineOptions.color(ContextCompat.getColor(this, R.color.yellow))
        polylineOptions.add(LatLng(_tour.latitude, _tour.longitude))
        polylineOptions.add(LatLng(1.0, 1.0))
        val polyLine = map.addPolyline(polylineOptions)
    }

    private fun createFragment() {
        val mapFragment: SupportMapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        map = googleMap!!
        createMarker()
    }

    private fun createMarker() {
        val coordinates = LatLng(_tour.latitude, _tour.longitude)
        val marker = MarkerOptions().position(coordinates).title("Título de ejemplo")
        map.addMarker(marker)
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinates, 16f), 10000, null)
    }
}