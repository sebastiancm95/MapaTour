package com.example.moviltours

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.moviltours.Tour.Tour
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
        binding.btnTourSugerido.setOnClickListener { createPolyLines() }
        binding.btnCambiarTipoMapa.setOnClickListener { cambiarTipoMapa() }
        _tour = intent.getSerializableExtra(tour_name) as Tour
        binding.tvTituloMapa.text = _tour.name
        createFragment()
    }

    private fun cambiarTipoMapa() {
        if (map.mapType == GoogleMap.MAP_TYPE_SATELLITE) {
            map.mapType = GoogleMap.MAP_TYPE_NORMAL
        } else {
            map.mapType = GoogleMap.MAP_TYPE_SATELLITE
        }
    }

    private fun createPolyLines() {
        val polylineOptions = PolylineOptions()
        polylineOptions.startCap(RoundCap())
        polylineOptions.endCap(CustomCap(BitmapDescriptorFactory.fromResource(R.drawable.flag)))
        polylineOptions.pattern(listOf(Dot(), Gap(10f), Dash(50f), Gap(10f)))
        polylineOptions.width(25f)
        polylineOptions.color(ContextCompat.getColor(this, R.color.yellow))
        polylineOptions.add(LatLng(_tour.latitude, _tour.longitude))
        if (!_tour.travel.isEmpty()) {
            for (item in _tour.travel) {
                polylineOptions.add(item)
            }
        } else {
            Toast.makeText(this, "Este destino no posee un tour planificado", Toast.LENGTH_LONG).show()
        }
        val polyLine = map.addPolyline(polylineOptions)
    }

    private fun createFragment() {
        val mapFragment: SupportMapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        map = googleMap!!
        map.mapType = GoogleMap.MAP_TYPE_SATELLITE
        createMarker()
    }

    private fun createMarker() {
        val coordinates = LatLng(_tour.latitude, _tour.longitude)
        val marker = MarkerOptions().position(coordinates).title(_tour.name)
        map.addMarker(marker)
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinates, 16f), 10000, null)
    }
}