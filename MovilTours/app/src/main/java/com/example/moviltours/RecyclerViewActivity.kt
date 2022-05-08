package com.example.moviltours

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviltours.adapter.TourAdapter
import com.example.moviltours.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
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
        Toast.makeText(this, tour.toString(), Toast.LENGTH_SHORT).show()
        val intent = Intent(this, Test::class.java)
        intent.putExtra(Test.tour_name, tour)
        startActivity(intent)
    }
}