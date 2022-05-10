package com.example.moviltours

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviltours.adapter.TourAdapter
import com.example.moviltours.databinding.ActivityRecyclerViewBinding
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()

        initLoadAds ()
    }

    private fun initLoadAds () {
        val adRequest = AdRequest.Builder ().build()

        binding.addListaTours.loadAd(adRequest)

        binding.addListaTours.adListener = object : AdListener() {

            override fun onAdLoaded () {
                mostrarToast()
            }
        }
    }

    private fun mostrarToast () {
        val mensaje = "En un segundo verás un increíble anuncio"

        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(this)
        binding.recyclerTours.layoutManager = LinearLayoutManager(this)
        binding.recyclerTours.adapter =
            TourAdapter(TourProvider.tourList) { tour ->
                onItemSelected(
                    tour
                )
            }
    }

    fun onItemSelected(tour: Tour) {
        Toast.makeText(this, tour.toString(), Toast.LENGTH_LONG).show()
        val intent = Intent(this, MapActivity::class.java)
        intent.putExtra(MapActivity.tour_name, tour)
        startActivity(intent)
    }
}