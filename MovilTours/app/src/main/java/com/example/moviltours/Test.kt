package com.example.moviltours

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Test : AppCompatActivity() {

    companion object{
        val tour_name = "tour passed"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
    val tour = intent.getSerializableExtra(tour_name) as Tour
        findViewById<TextView>(R.id.testTextView).text = tour.toString()
    }
}