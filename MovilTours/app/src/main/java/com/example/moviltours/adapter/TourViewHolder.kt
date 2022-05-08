package com.example.moviltours.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviltours.R
import com.example.moviltours.Tour

class TourViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val name = view.findViewById<TextView>(R.id.tvTourName)
    val price = view.findViewById<TextView>(R.id.tvTourPrice)
    val photo = view.findViewById<ImageView>(R.id.ivTour)

    fun render(tourModel: Tour) {
        name.text = tourModel.name
        price.text = tourModel.price
        Glide.with(photo.context).load(tourModel.photo).into(photo)
    }
}